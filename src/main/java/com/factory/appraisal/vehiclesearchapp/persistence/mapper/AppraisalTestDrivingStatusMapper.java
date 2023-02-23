package com.factory.appraisal.vehiclesearchapp.persistence.mapper;
//@author:Rupesh Khade

import com.factory.appraisal.vehiclesearchapp.persistence.dto.*;
import com.factory.appraisal.vehiclesearchapp.persistence.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppraisalTestDrivingStatusMapper {

    AppraisalVehicleMapper INSTANCE1 = Mappers.getMapper( AppraisalVehicleMapper.class);
    AppraisalVehicleAcConditionMapper INSTANCE2 = Mappers.getMapper(AppraisalVehicleAcConditionMapper.class);
    AppraisalVehicleInteriorConditionMapper INSTANCE3 = Mappers.getMapper(AppraisalVehicleInteriorConditionMapper.class);
    AppraisalVehicleOilConditionMapper INSTANCE4 = Mappers.getMapper(AppraisalVehicleOilConditionMapper.class);
    AppraisalVehicleStereoStatusMapper INSTANCE5 = Mappers.getMapper(AppraisalVehicleStereoStatusMapper.class);
    AppraisalVehicleTireConditionMapper INSTANCE6 = Mappers.getMapper(AppraisalVehicleTireConditionMapper.class);
    VehicleDrivingWarnLightStatusMapper INSTANCE7 = Mappers.getMapper(VehicleDrivingWarnLightStatusMapper.class);




    @Mapping(target = "appraisalRef",ignore = true)
    @Mapping(target = "appraisalVehicleAcCondition",ignore = true)
    @Mapping(target = "appraisalVehicleInteriorCondition",ignore = true)
    @Mapping(target = "appraisalVehicleOilCondition",ignore = true)
    @Mapping(target = "appraisalVehicleStereoStatus",ignore = true)
    @Mapping(target = "appraisalVehicleTireCondition",ignore = true)
    @Mapping(target = "vehicleDrivingWarnLightStatus",ignore = true)
    AppraisalTestDriveStatus modelToDto(EAppraisalTestDriveStatus eAppraisalTestDrivingStatus);  //ignore  due to  recursion problem in mapstruct, entities having bidirectional relationship

    @Mapping(target ="appraisalRef",expression = "java( mapAppraisalRef(appraisalTestDrivingStatus.getAppraisalRef()))")
    @Mapping(target ="appraisalRef.appraisalTestDriveStatus",ignore = true)


    @Mapping(target ="appraisalVehicleAcCondition",expression = "java( mapAppraisalVehicleAcCondition(appraisalTestDrivingStatus.getAppraisalVehicleAcCondition()))")
    @Mapping(target ="appraisalVehicleAcCondition.vehicleStatus",ignore = true)

    @Mapping(target ="appraisalVehicleInteriorCondition",expression = "java( mapAppraisalVehicleInteriorCondition(appraisalTestDrivingStatus.getAppraisalVehicleInteriorCondition()))")
    @Mapping(target ="appraisalVehicleInteriorCondition.vehicleStatus",ignore = true)

    @Mapping(target ="appraisalVehicleOilCondition",expression = "java(  mapAppraisalVehicleOilCondition(appraisalTestDrivingStatus.getAppraisalVehicleOilCondition()))")
    @Mapping(target ="appraisalVehicleOilCondition.vehicleStatus",ignore = true)

    @Mapping(target ="appraisalVehicleStereoStatus",expression = "java( mapAppraisalVehicleStereoStatus(appraisalTestDrivingStatus.getAppraisalVehicleStereoStatus()))")
    @Mapping(target ="appraisalVehicleStereoStatus.vehicleStatus",ignore = true)

    @Mapping(target ="appraisalVehicleTireCondition",expression = "java( mapAppraisalVehicleTireCondition(appraisalTestDrivingStatus.getAppraisalVehicleTireCondition()))")
    @Mapping(target ="appraisalVehicleTireCondition.vehicleStatus",ignore = true)

    @Mapping(target ="vehicleDrivingWarnLightStatus",expression = "java( mapVehicleDrivingWarnLightStatus(appraisalTestDrivingStatus.getVehicleDrivingWarnLightStatus()))")
    @Mapping(target ="vehicleDrivingWarnLightStatus.vehicleStatus",ignore = true)
    EAppraisalTestDriveStatus dtoToModel(AppraisalTestDriveStatus appraisalTestDrivingStatus);


    default EAppraiseVehicle mapAppraisalRef(AppraiseVehicle appraisalVehicle){

        return INSTANCE1.dtoToModel(appraisalVehicle);
    }
    default EAppraisalVehicleAcCondition mapAppraisalVehicleAcCondition(AppraisalVehicleAcCondition appraisalVehicleAcCondition){

        return INSTANCE2.dtoToModel(appraisalVehicleAcCondition);
    }
    default EAppraisalVehicleInteriorCondition mapAppraisalVehicleInteriorCondition(AppraisalVehicleInteriorCondition interiorCondition){

        return INSTANCE3.dtoToModel(interiorCondition);
    }
    default EAppraisalVehicleOilCondition mapAppraisalVehicleOilCondition(AppraisalVehicleOilCondition oilCondition){

        return INSTANCE4.dtoToModel(oilCondition);
    }
    default EAppraisalVehicleStereoStatus mapAppraisalVehicleStereoStatus(AppraisalVehicleStereoStatus vehicleStereoStatus){

        return INSTANCE5.dtoToModel(vehicleStereoStatus );
    }
    default EAppraisalVehicleTireCondition mapAppraisalVehicleTireCondition(AppraisalVehicleTireCondition tireCondition){

        return INSTANCE6.dtoToModel(tireCondition);
    }
    default EVehicleDrivingWarnLightStatus mapVehicleDrivingWarnLightStatus(VehicleDrivingWarnLightStatus warnLightStatus){

        return INSTANCE7.DtoToEntity(warnLightStatus);
    }


}
