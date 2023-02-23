package com.factory.appraisal.vehiclesearchapp.controller;
//Author:yudhister vijay

import com.factory.appraisal.vehiclesearchapp.persistence.dto.SignDet;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.UserRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.model.ESignDet;

import com.factory.appraisal.vehiclesearchapp.services.ESignDetServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Esign")
@Api(value = "ESignDetController" , description = "Operations in EsignDet")
public class ESignDetController {
    @Autowired
    private ESignDetServiceImpl eSignDetService;

    @ApiOperation(value = "Add EsignDet in database")

    @PostMapping("/saveESignDet")
    public ResponseEntity<SignDet> saveEsign(@RequestBody @Valid SignDet signDet){
        return new ResponseEntity<>(eSignDetService.saveESignDet(signDet), HttpStatus.CREATED);
    }
    @GetMapping("/getEsign")
    public ResponseEntity<List<SignDet>> getAllEsign(){
        return new ResponseEntity<>(eSignDetService.getEsign(),HttpStatus.OK);
    }

}
