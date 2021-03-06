package com.readcsvfile.devapp.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.readcsvfile.devapp.controller.CSVController;
import com.readcsvfile.devapp.model.CityRoutes;

public class CityRoutesUtils {

    final static Logger logger = LogManager.getLogger(CityRoutesUtils.class.getName());
	private static Map<String, List<CityRoutes>> cityRoutesMap = new HashMap<>();
	
	public static Map<String, List<CityRoutes>> getCityRoutes(String fileName) {
		if(cityRoutesMap.isEmpty()) {
			cityRoutesMap= readCityRoutes(fileName);
		}
		return cityRoutesMap;
	}
	
	public static Map<String, List<CityRoutes>> readCityRoutes(String fileName) {
		Pattern pattern = Pattern.compile(",");
		ClassLoader classLoader = CSVController.class.getClassLoader();
		URL url = classLoader.getResource(fileName);

		try (BufferedReader in = new BufferedReader(new FileReader(url.getPath()))) {
			in.lines().skip(1).map(line -> {
				String[] x = pattern.split(line);
				return new CityRoutes(x[0], x[1], x[2], Integer.parseInt(x[3]), Integer.parseInt(x[4]));
			}).forEach(c -> {
				if(cityRoutesMap.containsKey(c.getCity1())) {
					cityRoutesMap.get(c.getCity1()).add(c);
				} else {
					List<CityRoutes> cityR = new ArrayList<>();
					cityR.add(c);
					cityRoutesMap.put(c.getCity1(), cityR);
				}
			});
			return cityRoutesMap;
		} catch (IOException e) {
            logger.error(e);
		    return Collections.emptyMap();
		}

	}

}
