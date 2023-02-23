package com.factory.appraisal.vehiclesearchapp.persistence.mapper;
//@author:Rupesh Khade

import com.factory.appraisal.vehiclesearchapp.persistence.dto.*;
import com.factory.appraisal.vehiclesearchapp.persistence.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppraisalVehicleMapper {
    DealerRegistrationMapper INSTANCE1 = Mappers.getMapper(DealerRegistrationMapper.class);
    UserRegistrationMapper INSTANCE2 = Mappers.getMapper(UserRegistrationMapper.class);
    AppraisalTestDrivingStatusMapper INSTANCE3 = Mappers.getMapper(AppraisalTestDrivingStatusMapper.class);
    SignDetMapper INSTANCE4 = Mappers.getMapper(SignDetMapper.class);


    @Mapping(target = "dealer",ignore = true)
    @Mapping(target = "user",ignore = true)
    @Mapping(target = "appraisalTestDriveStatus",ignore = true)
    @Mapping(target ="signDet",ignore = true)
    AppraiseVehicle modelToDto(EAppraiseVehicle eAppraiseVehicle);


    @Mapping(target ="dealer",expression = "java(mapDealerReg(appraiseVehicle.getDealer()))")
    @Mapping(target ="user",expression = "java(mapUserReg(appraiseVehicle.getUser()))")
    @Mapping(target ="appraisalTestDriveStatus",expression = "java(mapAppraisalTestDriveStatus(appraiseVehicle.getAppraisalTestDriveStatus()))")
    @Mapping(target ="signDet",expression = "java(mapESignDet(appraiseVehicle.getSignDet()))")
    EAppraiseVehicle dtoToModel(AppraiseVehicle appraiseVehicle);




    List<EAppraiseVehicle> dtosToModels(List<AppraiseVehicle> appraiseVehicleList);

    List<AppraiseVehicle> modelsToDtos(List<EAppraiseVehicle> eAppraiseVehicleList);

default EDealerRegistration mapDealerReg(DealerRegistration dealerRegistrationDto){
    return INSTANCE1.dtoToModel(dealerRegistrationDto);
}
    default EUserRegistration mapUserReg(UserRegistration userRegistrationDto){
        return INSTANCE2.dtoToModel(userRegistrationDto);
    }
    default EAppraisalTestDriveStatus mapAppraisalTestDriveStatus(AppraisalTestDriveStatus appraisalTestDriveStatusDto){
        return INSTANCE3.dtoToModel(appraisalTestDriveStatusDto);
    }

    default ESignDet mapESignDet(SignDet signDetDto){

    return INSTANCE4.dtoToModel(signDetDto);
    }


}
