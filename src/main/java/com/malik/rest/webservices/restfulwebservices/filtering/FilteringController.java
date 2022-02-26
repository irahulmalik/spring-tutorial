package com.malik.rest.webservices.restfulwebservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("filtering")
	public SomeBean filtering() {
		return new SomeBean("String1", "string2", "string3");
	}
	
	@GetMapping("filtering-dynamic")
	public MappingJacksonValue filteringDynamic() {
		SomeBean someBean = new SomeBean("String1", "string2", "string3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
				filterOutAllExcept("string1");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}

}
