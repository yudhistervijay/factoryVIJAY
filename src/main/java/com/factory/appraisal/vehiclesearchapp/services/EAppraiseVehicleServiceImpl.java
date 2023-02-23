package com.factory.appraisal.vehiclesearchapp.services;
//Author:Rupesh khade
import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraiseVehicle;
import com.factory.appraisal.vehiclesearchapp.persistence.mapper.*;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraiseVehicle;
import com.factory.appraisal.vehiclesearchapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EAppraiseVehicleServiceImpl implements EAppraiseVehicleService {
    @Autowired
    EAppraiseVehicleRepo eAppraiseVehicleRepo;
    @Autowired
    EConfigurationCodesRepo eConfigurationCodesRepo;
    @Autowired
    EAppraisalTestDriveStatusRepo eAppraisalTestDriveStatusRepo;
    @Autowired
    EUserRegistrationRepo eUserRegistrationRepo;
    @Autowired
    EDealerRegistrationRepo eDealerRegistrationRepo;
    @Autowired
    private ESignDetRepo eSignDetRepo;
    @Autowired
    private AppraisalVehicleMapper appraisalVehicleMapper;
    @Autowired
    private DealerRegistrationMapper dealerRegistrationMapper;
    @Autowired
    private UserRegistrationMapper userRegistrationMapper;
    @Autowired
    private AppraisalTestDrivingStatusMapper appraisalTestDrivingStatusMapper;
    @Autowired
    private ConfigCodesMapper configCodesMapper;
    @Autowired
    private SignDetMapper signDetMapper;

    @Override
    public List<AppraiseVehicle> GetAppraisals() {
        List<EAppraiseVehicle> apv= (List<EAppraiseVehicle>) eAppraiseVehicleRepo.findAll();

        List<AppraiseVehicle> appraiseVehicleDtos= appraisalVehicleMapper.modelsToDtos(apv);

        ArrayList<EAppraiseVehicle> al1= new ArrayList<>(apv);
        ArrayList<AppraiseVehicle>al2= new ArrayList<>(appraiseVehicleDtos);
        for(int i=0;i<al1.size();i++){
            al2.get(i).setDealer(dealerRegistrationMapper.modeltoDto(al1.get(i).getDealer()));
            al2.get(i).setUser(userRegistrationMapper.modelToDto(al1.get(i).getUser()));
            al2.get(i).setAppraisalTestDriveStatus(appraisalTestDrivingStatusMapper.modelToDto(al1.get(i).getAppraisalTestDriveStatus()));
            al2.get(i).getUser().setRoleConfig(configCodesMapper.modelToDto(al1.get(i).getUser().getRoleConfig()));
            al2.get(i).setSignDet(signDetMapper.modelToDto(al1.get(i).getSignDet()));
        }

        List<AppraiseVehicle> appraiseVehicleDtos1=al2;
        return appraiseVehicleDtos1;
    }

    @Override
    public AppraiseVehicle addAppraiseVehicle(AppraiseVehicle appraiseVehicle) {

       EAppraiseVehicle eAppraiseVehicle= appraisalVehicleMapper.dtoToModel(appraiseVehicle);

        eAppraiseVehicle.getDealer().setConfigCodes(eAppraiseVehicle.getUser().getRoleConfig());
        eAppraiseVehicle.getUser().setRoleConfig(eAppraiseVehicle.getUser().getRoleConfig());

        eAppraiseVehicle.getUser().setDealer(eAppraiseVehicle.getDealer());
        eAppraiseVehicle.setUser(eAppraiseVehicle.getUser());
        eAppraiseVehicle.setDealer(eAppraiseVehicle.getDealer());
        eAppraiseVehicle.setAppraisalTestDriveStatus(eAppraiseVehicle.getAppraisalTestDriveStatus());
        eAppraiseVehicle.getAppraisalTestDriveStatus().setAppraisalRef(eAppraiseVehicle);


        eConfigurationCodesRepo.save(eAppraiseVehicle.getUser().getRoleConfig());//1
        eDealerRegistrationRepo.save(eAppraiseVehicle.getDealer());//2
        eUserRegistrationRepo.save(eAppraiseVehicle.getUser());//3

       EAppraiseVehicle eAppraiseVehicle1=eAppraiseVehicleRepo.save(eAppraiseVehicle);//4
       eAppraisalTestDriveStatusRepo.save(eAppraiseVehicle.getAppraisalTestDriveStatus());//5


       return appraisalVehicleMapper.modelToDto(eAppraiseVehicle);

    }
    @Override
    public AppraiseVehicle findByVinNumber(String vinNum) {
        EAppraiseVehicle apv = eAppraiseVehicleRepo.findByVinNumber(vinNum);

        AppraiseVehicle appraiseVehicleDto= appraisalVehicleMapper.modelToDto(apv);

        appraiseVehicleDto.setDealer(dealerRegistrationMapper.modeltoDto(apv.getDealer()));
        appraiseVehicleDto.setUser(userRegistrationMapper.modelToDto(apv.getUser()));
        appraiseVehicleDto.setAppraisalTestDriveStatus(appraisalTestDrivingStatusMapper.modelToDto(apv.getAppraisalTestDriveStatus()));
        appraiseVehicleDto.getUser().setRoleConfig(configCodesMapper.modelToDto(apv.getUser().getRoleConfig()));
        appraiseVehicleDto.setSignDet(signDetMapper.modelToDto(apv.getSignDet()));

        return  appraiseVehicleDto;

    }

    @Override
    public AppraiseVehicle updateAppraisalVehicle(AppraiseVehicle eAppraiseVehicledto) {
        EAppraiseVehicle vehicle = eAppraiseVehicleRepo.findByVinNumber(eAppraiseVehicledto.getVinNumber());
        if(vehicle!=null){

            if(eAppraiseVehicledto.getAppraisalTestDriveStatus().getAppraisalRef()==null){

                eAppraiseVehicledto.getAppraisalTestDriveStatus().setAppraisalRef(appraisalVehicleMapper.modelToDto(vehicle));

            }

            vehicle.setAppraisalTestDriveStatus(appraisalTestDrivingStatusMapper.dtoToModel(eAppraiseVehicledto.getAppraisalTestDriveStatus()));

            eAppraiseVehicleRepo.save(vehicle);


            AppraiseVehicle appraiseVehicleDto= appraisalVehicleMapper.modelToDto(vehicle);
            appraiseVehicleDto.setAppraisalTestDriveStatus(appraisalTestDrivingStatusMapper.modelToDto(vehicle.getAppraisalTestDriveStatus()));

            return appraiseVehicleDto;
        }

       else throw new RuntimeException("Did not find AppraisalVehicle of "+eAppraiseVehicledto.getVinNumber() );

    }

    @Override
    public String deleteAppraisalVehicle(String vinNum) {
        EAppraiseVehicle byVinNumber = eAppraiseVehicleRepo.findByVinNumber(vinNum);
        if(byVinNumber!=null) {
            byVinNumber.setValid(false);
            eAppraiseVehicleRepo.save(byVinNumber);

            return "deleted";
        }
        else
        throw new RuntimeException("Did not find AppraisalVehicle of  - " + vinNum);
    }
}
