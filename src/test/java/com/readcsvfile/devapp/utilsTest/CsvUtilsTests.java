package com.readcsvfile.devapp.utilsTests;


import com.readcsvfile.devapp.model.CityRoutes;
import com.readcsvfile.devapp.utils.CityRoutesUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.misusing.NotAMockException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;


@RunWith(SpringJUnit4ClassRunner.class)
public class CsvUtilsTests {
    @InjectMocks
    private CityRoutesUtils cityRoutesUtils;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    String fileName = "Routes.csv";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCityRoutesUtils() {
        Map<String, List<CityRoutes>> result = cityRoutesUtils.getCityRoutes(fileName);
        assertNotNull(result);
    }

    @Test(expected = NullPointerException.class)
    public void testExceptionGetCityRoutesUtils() {
        doThrow(IOException.class).when(exception).expectMessage((String) any());
        Map<String, List<CityRoutes>> result = cityRoutesUtils.readCityRoutes(ArgumentMatchers.anyString());





    }
}
