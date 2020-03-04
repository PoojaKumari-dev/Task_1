package com.readcsvfile.devapp.serviceTests;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.readcsvfile.devapp.model.CityRoutes;
import com.readcsvfile.devapp.service.CityRoutesService;
import com.readcsvfile.devapp.utils.CityRoutesUtils;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class CsvServiceTests {

    @InjectMocks
    private CityRoutesService cityRoutesService;

    @Mock
    private CityRoutesUtils cityRoutesUtils;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCityRoutesService() throws JsonGenerationException, JsonMappingException, IOException {
        //ReflectionTestUtils.setField(cityRoutesService, "fileName",fileName);
        CityRoutes city = new CityRoutes("ABC", "PQR","LMN", 0,1);

        Map<String, List<CityRoutes>> cityMap =  new HashMap<String, List<CityRoutes>>();
        cityMap.put(city.getCity1(), Lists.newArrayList(city));
        when(cityRoutesUtils.getCityRoutes(ArgumentMatchers.any())).thenReturn(cityMap);
        List<CityRoutes> result = cityRoutesService.readCsvDataCity("ABC");

        assertEquals("ABC", result.get(0).getCity1());
        assertEquals("PQR", result.get(0).getCity2());
        assertEquals("LMN", result.get(0).getCity3());
        assertEquals(0, result.get(0).getMint());
        assertEquals(1, result.get(0).getSeasonal());


    }

}
