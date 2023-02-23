package com.factory.appraisal.vehiclesearchapp.controller;
//@author:Rupesh Khade

import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraiseVehicle;
import com.factory.appraisal.vehiclesearchapp.persistence.mapper.*;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraiseVehicle;
import com.factory.appraisal.vehiclesearchapp.services.EAppraiseVehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/appraisal")
public class AppraisalVehicleController {

    @Autowired
    private EAppraiseVehicleServiceImpl service;

    @PostMapping("/addAppraiseVehicle")
    public ResponseEntity<AppraiseVehicle> addAppraiseVehicle(@RequestBody AppraiseVehicle appraiseVehicle){

        return new ResponseEntity<>(service.addAppraiseVehicle(appraiseVehicle), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAppraisals")
    public ResponseEntity<List<AppraiseVehicle>> getAppraisals(){
        List<AppraiseVehicle> apv= service.GetAppraisals();


        return new ResponseEntity<>(apv,HttpStatus.ACCEPTED);

    }

    @GetMapping("/getAppraisal/{vinNum}")
    public ResponseEntity<AppraiseVehicle> showAppraisalVehicle(@PathVariable String vinNum){
       AppraiseVehicle appraiseVehicleDto= service.findByVinNumber(vinNum);
       return new ResponseEntity<>(appraiseVehicleDto,HttpStatus.ACCEPTED);

    }

    @PutMapping("/updateAppraisalVehicle/{vinNum}")
    public ResponseEntity<AppraiseVehicle> updateAppraisalVehicle(@RequestBody AppraiseVehicle appraiseVehicle) {
        AppraiseVehicle appraiseVehicleDto= service.updateAppraisalVehicle(appraiseVehicle);
        return new ResponseEntity<>(appraiseVehicleDto,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteAppraisal/{vinNum}")
    public String deleteAppraisal(@PathVariable String vinNum){
        return  service.deleteAppraisalVehicle(vinNum);
    }

}
