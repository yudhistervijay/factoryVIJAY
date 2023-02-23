package com.factory.appraisal.vehiclesearchapp.persistence.mapper;

import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraisalTestDriveStatus;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraisalVehicleInteriorCondition;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraisalTestDriveStatus;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraisalVehicleInteriorCondition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppraisalVehicleInteriorConditionMapper {
    AppraisalTestDrivingStatusMapper INSTANCE = Mappers.getMapper(AppraisalTestDrivingStatusMapper.class);

    @Mapping(target = "vehicleStatus",ignore = true)
    AppraisalVehicleInteriorCondition modelToDto(EAppraisalVehicleInteriorCondition eAppraisalVehicleInteriorCondition);

    @Mapping(target ="vehicleStatus",expression = "java( mapAppraisalTestDriveStatus(appraisalVehicleInteriorCondition.getVehicleStatus()))")
    EAppraisalVehicleInteriorCondition dtoToModel(AppraisalVehicleInteriorCondition appraisalVehicleInteriorCondition);

    default EAppraisalTestDriveStatus mapAppraisalTestDriveStatus(AppraisalTestDriveStatus appraisalTestDriveStatusDto){
        return INSTANCE.dtoToModel(appraisalTestDriveStatusDto);
    }

}
