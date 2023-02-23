package com.factory.appraisal.vehiclesearchapp.persistence.mapper;

//author:yudhister vijay

import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraiseVehicle;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.DealerRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.SignDet;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.UserRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraiseVehicle;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EDealerRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.model.ESignDet;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EUserRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SignDetMapper {

    AppraisalVehicleMapper INSTANCE1 = Mappers.getMapper(AppraisalVehicleMapper.class);
    @Mapping(target = "appraisalReference",ignore = true)
    SignDet modelToDto(ESignDet eSignDet);

    @Mapping(target = "appraisalReference",expression = "java(mapAppraisalReferenceId(signDet.getAppraisalReference()))")
    ESignDet dtoToModel(SignDet signDet);

    default EAppraiseVehicle mapAppraisalReferenceId(AppraiseVehicle appraiseVehicleDto){
        return INSTANCE1.dtoToModel(appraiseVehicleDto);
    }

    List<SignDet> modelToDto(List<ESignDet> eSignDetList);



}
