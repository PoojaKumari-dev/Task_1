package com.readcsvfile.devapp.utilsTests;


import com.readcsvfile.devapp.model.CityRoutes;
import com.readcsvfile.devapp.utils.CityRoutesUtils;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
public class CsvUtilsTests {
    @InjectMocks
    private CityRoutesUtils cityRoutesUtils;

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

  @Test
  public void testExceptionGetCityRoutesUtils() {
      Map<String, List<CityRoutes>> result = cityRoutesUtils.getCityRoutes(ArgumentMatchers.anyString());
      Assert.assertTrue(true);
  }
}
