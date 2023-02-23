package com.factory.appraisal.vehiclesearchapp.persistence.mapper;

import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraisalTestDriveStatus;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraisalVehicleTireCondition;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraisalTestDriveStatus;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraisalVehicleTireCondition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppraisalVehicleTireConditionMapper {

    AppraisalTestDrivingStatusMapper INSTANCE = Mappers.getMapper(AppraisalTestDrivingStatusMapper.class);
    @Mapping(target = "vehicleStatus",ignore = true)
    AppraisalVehicleTireCondition modelToDto(EAppraisalVehicleTireCondition eAppraisalVehicleTireCondition);

    @Mapping(target = "vehicleStatus",expression = "java( mapAppraisalTestDriveStatus(appraisalVehicleTireCondition.getVehicleStatus()))")
    EAppraisalVehicleTireCondition dtoToModel(AppraisalVehicleTireCondition appraisalVehicleTireCondition);

    default EAppraisalTestDriveStatus mapAppraisalTestDriveStatus(AppraisalTestDriveStatus appraisalTestDriveStatusDto) {
        return INSTANCE.dtoToModel(appraisalTestDriveStatusDto);
    }
}
