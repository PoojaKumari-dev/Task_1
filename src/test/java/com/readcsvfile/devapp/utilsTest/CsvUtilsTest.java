package com.readcsvfile.devapp.utilsTest;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.readcsvfile.devapp.model.CityRoutes;
import com.readcsvfile.devapp.utils.CityRoutesUtils;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.constraints.Null;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
public class CsvUtilsTest {
    @Mock
    private CityRoutesUtils cityRoutesUtils;

    String fileName = "Routes.csv";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetCityRoutesUtilsWithoutNull() throws JsonGenerationException, JsonMappingException, IOException {
        CityRoutes city = new CityRoutes("ABC", "PQR","LMN", 0,1);
        Map<String, List<CityRoutes>> cityMap =  new HashMap<String, List<CityRoutes>>();
        cityMap.put(city.getCity1(), Lists.newArrayList(city));
        Map<String, List<CityRoutes>> result = cityRoutesUtils.getCityRoutes(fileName);
        assertNotNull(result);
    }


    @Test
    public void testGetCityRoutesUtilsWithNull() throws JsonGenerationException, JsonMappingException, IOException {
        Map<String, List<CityRoutes>> cityRoutesMap = new HashMap<String, List<CityRoutes>>();
        Assert.assertTrue(cityRoutesMap.isEmpty());
        CityRoutes city = new CityRoutes("ABC", "PQR","LMN", 0,1);
        cityRoutesMap.put(city.getCity1(), Lists.newArrayList(city));
        when(cityRoutesUtils.getCityRoutes(fileName)).thenReturn(cityRoutesMap);
        Map<String, List<CityRoutes>> result = cityRoutesUtils.readCityRoutes(fileName);
        assertNotNull(result);
    }





}
