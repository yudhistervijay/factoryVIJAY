package com.factory.appraisal.vehiclesearchapp.services;
//Author:yudhister vijay
import com.factory.appraisal.vehiclesearchapp.persistence.dto.SignDet;
import com.factory.appraisal.vehiclesearchapp.persistence.mapper.SignDetMapper;
import com.factory.appraisal.vehiclesearchapp.persistence.model.ESignDet;
import com.factory.appraisal.vehiclesearchapp.repository.ESignDetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ESignDetServiceImpl implements ESignDetService{
    @Autowired
    private ESignDetRepo eSignDetRepo;
    @Autowired
    private SignDetMapper signDetMapper;


    @Override
    public SignDet saveESignDet(SignDet signDet) {
        ESignDet eSignDet=signDetMapper.dtoToModel(signDet);
        ESignDet save=eSignDetRepo.save(eSignDet);
        return signDetMapper.modelToDto(save);
    }


    @Override
    public List<SignDet> getEsign() {
        List<ESignDet> getEsign = eSignDetRepo.findAll();
        return signDetMapper.modelToDto(getEsign);
    }
}
