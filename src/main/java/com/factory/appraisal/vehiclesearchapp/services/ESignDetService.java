package com.factory.appraisal.vehiclesearchapp.services;
//Author:yudhister vijay

import com.factory.appraisal.vehiclesearchapp.persistence.dto.SignDet;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.UserRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.model.ESignDet;

import java.util.List;

public interface ESignDetService {
    public SignDet saveESignDet(SignDet SignDet);
    List<SignDet> getEsign();


}
