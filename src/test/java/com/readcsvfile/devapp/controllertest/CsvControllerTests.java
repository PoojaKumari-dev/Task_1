package com.readcsvfile.devapp.controllerTests;

import com.readcsvfile.devapp.controller.CSVController;
import com.readcsvfile.devapp.model.CityRoutes;
import com.readcsvfile.devapp.service.CityRoutesService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@WebMvcTest(CSVController.class)
public class CsvControllerTests {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private CityRoutesService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getCsvControllerTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        CityRoutes city = new CityRoutes("ABC", "PQR","LMN", 0,1);
        List<CityRoutes> cityList =  new ArrayList<CityRoutes>();
        cityList.add(city);
        when(service.readCsvDataCity("ABC")).thenReturn(cityList);
        MvcResult mvcResult = mvc.perform(get("/routes/ABC").accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
        List<CityRoutes> result = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<CityRoutes>>() {
        });
        assertThat(result.size()).isEqualTo(1);
    }

}
