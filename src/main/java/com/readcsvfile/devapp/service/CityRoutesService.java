package com.readcsvfile.devapp.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.readcsvfile.devapp.model.CityRoutes;
import com.readcsvfile.devapp.utils.CityRoutesUtils;

@Service
public class CityRoutesService {
	@Value("${file.location1:test}")
	private String fileName;
	public List<CityRoutes> readCsvDataCity(String city1) throws JsonGenerationException, JsonMappingException, IOException
	{
		//String fileName = "Routes.csv";
		return CityRoutesUtils.getCityRoutes(fileName).get(city1);
	}

}
