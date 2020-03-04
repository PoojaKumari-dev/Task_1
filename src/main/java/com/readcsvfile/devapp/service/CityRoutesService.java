package com.readcsvfile.devapp.service;

import com.readcsvfile.devapp.model.CityRoutes;
import com.readcsvfile.devapp.utils.CityRoutesUtils;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CityRoutesService {

    @Value("${file.location1:test}")
    private String fileName;
    @Autowired
    private CityRoutesUtils cityRoutesUtils;
    public List<CityRoutes> readCsvDataCity(String city1) throws JsonGenerationException, JsonMappingException, IOException
    {
        //String fileName = "Routes.csv";
        return cityRoutesUtils.getCityRoutes(fileName).get(city1);
    }
}
