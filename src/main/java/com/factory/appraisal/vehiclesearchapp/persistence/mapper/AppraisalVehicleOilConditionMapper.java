package com.factory.appraisal.vehiclesearchapp.persistence.mapper;

import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraisalTestDriveStatus;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraisalVehicleOilCondition;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraisalTestDriveStatus;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraisalVehicleOilCondition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppraisalVehicleOilConditionMapper {

    AppraisalTestDrivingStatusMapper INSTANCE = Mappers.getMapper(AppraisalTestDrivingStatusMapper.class);

    @Mapping(target ="vehicleStatus",ignore = true)
    AppraisalVehicleOilCondition modelToDto(EAppraisalVehicleOilCondition eAppraisalVehicleOilCondition);
    @Mapping(target = "vehicleStatus",expression = "java( mapAppraisalTestDriveStatus(appraisalVehicleOilCondition.getVehicleStatus()))")
    EAppraisalVehicleOilCondition dtoToModel(AppraisalVehicleOilCondition appraisalVehicleOilCondition);



    default EAppraisalTestDriveStatus mapAppraisalTestDriveStatus(AppraisalTestDriveStatus appraisalTestDriveStatusDto){
        return INSTANCE.dtoToModel(appraisalTestDriveStatusDto);
    }
}
