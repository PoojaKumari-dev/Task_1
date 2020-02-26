package com.readcsvfile.devapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2
@Configuration
@ComponentScan
@PropertySource(value="classpath:application.properties")
public class ReadCsvDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadCsvDataApplication.class, args);
	}
	@Bean
	   public Docket readCsvDataApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.readcsvfile.devapp")).build().apiInfo(apiInfo());
	   }
	
	 private ApiInfo apiInfo() {
			return new ApiInfoBuilder().title("Read CSV file API")
					.description("ReadCsv API to get the data according to the city code")
					.build();
		}

}
