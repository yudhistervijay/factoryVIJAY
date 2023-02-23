package com.factory.appraisal.vehiclesearchapp.controller;

//@Author: Rupesh Khade
import com.factory.appraisal.vehiclesearchapp.persistence.dto.ConfigurationCodes;
import com.factory.appraisal.vehiclesearchapp.persistence.mapper.ConfigCodesMapper;

import com.factory.appraisal.vehiclesearchapp.services.EConfigurationCodesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/configCodes")
public class ConfigurationCodesController {


    @Autowired
    private ConfigCodesMapper mapper;
    @Autowired
    private EConfigurationCodesServiceImpl service;
    @PostMapping("/addConfigCode")
    public ResponseEntity<ConfigurationCodes> addConfigCode (@RequestBody ConfigurationCodes ConfigurationCodes){

        return  new ResponseEntity<>(mapper.modelToDto(service.addConfigCode(mapper.dtoToModel(ConfigurationCodes))), HttpStatus.ACCEPTED);

    }
}
