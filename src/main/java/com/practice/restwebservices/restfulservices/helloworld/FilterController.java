package com.practice.restwebservices.restfulservices.helloworld;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilterController {

    @GetMapping(path = "/filtering")
    public MappingJacksonValue getBean() {
        SomeBean someBean = new SomeBean("1", "2", "3");

        MappingJacksonValue jacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        jacksonValue.setFilters(filterProvider);
        return jacksonValue;
    }


    @GetMapping(path = "/filtering-list")
    public MappingJacksonValue getBeans() {
        List<SomeBean> someBeans = Arrays.asList(new SomeBean("1", "2", "3"), new SomeBean("1", "2", "3"));
        MappingJacksonValue jacksonValue = new MappingJacksonValue(someBeans);
        SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("value3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", propertyFilter);
        jacksonValue.setFilters(filterProvider);
        return jacksonValue;
    }
}

