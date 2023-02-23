package com.factory.appraisal.vehiclesearchapp.persistence.mapper;
//Author:Yudhister vijay
import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraisalTestDriveStatus;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.VehicleDrivingWarnLightStatus;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraisalTestDriveStatus;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EVehicleDrivingWarnLightStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface VehicleDrivingWarnLightStatusMapper {

    AppraisalTestDrivingStatusMapper INSTANCE = Mappers.getMapper(AppraisalTestDrivingStatusMapper.class);
    @Mapping(target ="vehicleStatus",expression = "java( mapAppraisalTestDriveStatus(vehicleDrivingWarnLightStatus.getVehicleStatus()))")
    EVehicleDrivingWarnLightStatus DtoToEntity (VehicleDrivingWarnLightStatus vehicleDrivingWarnLightStatus);

    @Mapping(target = "vehicleStatus",ignore = true)
    VehicleDrivingWarnLightStatus EntityToDto(EVehicleDrivingWarnLightStatus eVehicleDrivingWarnLightStatus);


    default EAppraisalTestDriveStatus mapAppraisalTestDriveStatus(AppraisalTestDriveStatus appraisalTestDriveStatusDto){
        return INSTANCE.dtoToModel(appraisalTestDriveStatusDto);
    }

    List<VehicleDrivingWarnLightStatus> EntityToDto(List<EVehicleDrivingWarnLightStatus> eVehicleDrivingWarnLightStatusList);
}

