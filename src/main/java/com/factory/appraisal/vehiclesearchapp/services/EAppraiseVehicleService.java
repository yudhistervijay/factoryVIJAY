package com.factory.appraisal.vehiclesearchapp.services;

import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraiseVehicle;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraiseVehicle;

import java.util.List;

public interface EAppraiseVehicleService {

    List<AppraiseVehicle> GetAppraisals();
    AppraiseVehicle addAppraiseVehicle(AppraiseVehicle eAppraiseVehicle);
    AppraiseVehicle findByVinNumber(String vinNum);
    AppraiseVehicle updateAppraisalVehicle(AppraiseVehicle appraiseVehicle);
    String deleteAppraisalVehicle(String vinNum);




}
