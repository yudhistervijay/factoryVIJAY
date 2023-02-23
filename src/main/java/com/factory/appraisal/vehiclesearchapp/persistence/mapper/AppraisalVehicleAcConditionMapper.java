package com.factory.appraisal.vehiclesearchapp.persistence.mapper;

//@author:Rupesh Khade

import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraisalTestDriveStatus;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraisalVehicleAcCondition;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraisalTestDriveStatus;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraisalVehicleAcCondition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppraisalVehicleAcConditionMapper {
    AppraisalTestDrivingStatusMapper INSTANCE = Mappers.getMapper(AppraisalTestDrivingStatusMapper.class);

    @Mapping(target = "vehicleStatus",ignore = true)
    AppraisalVehicleAcCondition modelToDto(EAppraisalVehicleAcCondition eAppraisalVehicleAcCondition);
    @Mapping(target ="vehicleStatus",expression = "java( mapAppraisalTestDriveStatus(appraisalVehicleAcCondition.getVehicleStatus()))")
    EAppraisalVehicleAcCondition dtoToModel(AppraisalVehicleAcCondition appraisalVehicleAcCondition);   //dto coming from ui has all data to save to entity


    default EAppraisalTestDriveStatus mapAppraisalTestDriveStatus(AppraisalTestDriveStatus appraisalTestDriveStatusDto){
        return INSTANCE.dtoToModel(appraisalTestDriveStatusDto);
    }
}
