package com.factory.appraisal.vehiclesearchapp.services;
//Author:yudhister vijay
import com.factory.appraisal.vehiclesearchapp.persistence.dto.UserRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.VehicleDrivingWarnLightStatus;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EVehicleDrivingWarnLightStatus;

import java.util.List;

public interface EVehicleDrivingWarnLightStatusService {
    VehicleDrivingWarnLightStatus addWarnLightStatus(VehicleDrivingWarnLightStatus vehicleDrivingWarnLightStatus);
    List<VehicleDrivingWarnLightStatus> getWarningLightStatusService();
//    VehicleDrivingWarnLightStatus updateWarnLightStatus(Long warningLightStatusId ,VehicleDrivingWarnLightStatus vehicleDrivingWarnLightStatus);

    String removeWarnLightStatus(Long warningLightStatusId);
}
