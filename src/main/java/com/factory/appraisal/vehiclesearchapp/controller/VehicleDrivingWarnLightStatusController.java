package com.factory.appraisal.vehiclesearchapp.controller;
//Author:yudhister vijay

import com.factory.appraisal.vehiclesearchapp.persistence.dto.UserRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.VehicleDrivingWarnLightStatus;
import com.factory.appraisal.vehiclesearchapp.services.EVehicleDrivingWarnLightStatusServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/warningLightStatus")
@Api(value = "VehicleDrivingWarnLightStatusController" , description = "Operations in vehicleWarningLightStatus")
public class VehicleDrivingWarnLightStatusController {

    @Autowired
    private EVehicleDrivingWarnLightStatusServiceImpl eVehicleDrivingWarnLightStatusService;

    @ApiOperation(value = "Add warning light status in database")

    @PostMapping("/addWarnLightStatus")
    public ResponseEntity<VehicleDrivingWarnLightStatus> addWarnLightStatus(@RequestBody @Valid VehicleDrivingWarnLightStatus vehicleDrivingWarnLightStatus){
        return new ResponseEntity<>(eVehicleDrivingWarnLightStatusService.addWarnLightStatus(vehicleDrivingWarnLightStatus), HttpStatus.CREATED);
    }

    @GetMapping("/getWarningLightStatusService")
    public ResponseEntity<List<VehicleDrivingWarnLightStatus>> getWarningLightStatusService(){
        return new ResponseEntity<>(eVehicleDrivingWarnLightStatusService.getWarningLightStatusService(),HttpStatus.OK);
    }

    @DeleteMapping("/removeWarnLightStatus")
    public ResponseEntity<String> removeWarnLightStatus(@PathVariable Long warningLightStatusId){
        return new ResponseEntity<>(eVehicleDrivingWarnLightStatusService.removeWarnLightStatus(warningLightStatusId),
                HttpStatus.OK
        );
    }

}
