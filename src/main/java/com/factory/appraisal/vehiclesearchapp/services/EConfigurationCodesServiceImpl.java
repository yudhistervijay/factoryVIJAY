package com.factory.appraisal.vehiclesearchapp.services;
//Author:Rupesh khade
import com.factory.appraisal.vehiclesearchapp.persistence.model.EConfigurationCodes;
import com.factory.appraisal.vehiclesearchapp.repository.EConfigurationCodesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EConfigurationCodesServiceImpl implements EConfigurationCodesService{
    @Autowired
    private EConfigurationCodesRepo eConfigurationCodesRepo;
    @Override
    public EConfigurationCodes addConfigCode(EConfigurationCodes eConfigurationCodes) {
        return eConfigurationCodesRepo.save(eConfigurationCodes);
    }
}
