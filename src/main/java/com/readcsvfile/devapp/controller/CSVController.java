package com.readcsvfile.devapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.readcsvfile.devapp.model.CityRoutes;
import com.readcsvfile.devapp.service.CityRoutesService;

@RestController
@RequestMapping("routes")
public class CSVController {
	
	@Autowired
	CityRoutesService cityRoutesService;

	@GetMapping("/{city1}")
	public ResponseEntity<List<CityRoutes>> readCsvCityRoutes(@PathVariable String city1) {
		try {
			return new ResponseEntity<>(cityRoutesService.readCsvDataCity(city1), HttpStatus.OK);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
