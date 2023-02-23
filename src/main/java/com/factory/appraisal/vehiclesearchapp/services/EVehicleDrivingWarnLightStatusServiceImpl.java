package com.factory.appraisal.vehiclesearchapp.services;
//Author:yudhister vijay
import com.factory.appraisal.vehiclesearchapp.persistence.dto.VehicleDrivingWarnLightStatus;
import com.factory.appraisal.vehiclesearchapp.persistence.mapper.VehicleDrivingWarnLightStatusMapper;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EUserRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EVehicleDrivingWarnLightStatus;
import com.factory.appraisal.vehiclesearchapp.repository.EVehicleDrivingWarnLightStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EVehicleDrivingWarnLightStatusServiceImpl implements EVehicleDrivingWarnLightStatusService{

    @Autowired
    private EVehicleDrivingWarnLightStatusRepo vehicleDrivingWarnLightStatusRepo;

    @Autowired
    private VehicleDrivingWarnLightStatusMapper vehicleDrivingWarnLightStatusMapper;


    @Override
    public VehicleDrivingWarnLightStatus addWarnLightStatus(VehicleDrivingWarnLightStatus vehicleDrivingWarnLightStatus) {
        EVehicleDrivingWarnLightStatus eVehicleDrivingWarnLightStatus=vehicleDrivingWarnLightStatusMapper.DtoToEntity(vehicleDrivingWarnLightStatus);
        EVehicleDrivingWarnLightStatus save=vehicleDrivingWarnLightStatusRepo.save(eVehicleDrivingWarnLightStatus);
        return vehicleDrivingWarnLightStatusMapper.EntityToDto(save);
    }

    @Override
    public List<VehicleDrivingWarnLightStatus> getWarningLightStatusService() {
        List<EVehicleDrivingWarnLightStatus> getAll=vehicleDrivingWarnLightStatusRepo.findAll();
        return vehicleDrivingWarnLightStatusMapper.EntityToDto(getAll);
    }

//    @Override
//    public VehicleDrivingWarnLightStatus updateWarnLightStatus(Long warningLightStatusId, VehicleDrivingWarnLightStatus vehicleDrivingWarnLightStatus) {
//
//        EVehicleDrivingWarnLightStatus warnLightStatus=vehicleDrivingWarnLightStatusRepo.findById(warningLightStatusId).get();
//        if(warnLightStatus!=null){
//            if(vehicleDrivingWarnLightStatus.getValid()!=false) {
//                if (vehicleDrivingWarnLightStatus.isNoFaults()!= null) {
//                    warnLightStatus.setNoFaults(vehicleDrivingWarnLightStatus.isNoFaults());
//                }
//
//        return null;
//    }


    @Override
    public String removeWarnLightStatus(Long warningLightStatusId) {
        vehicleDrivingWarnLightStatusRepo.deleteById(warningLightStatusId);
        return "deleted";
    }
}
