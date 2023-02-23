package com.factory.appraisal.vehiclesearchapp.services;
//Author:yudhister vijay
import com.factory.appraisal.vehiclesearchapp.persistence.dto.UserRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.mapper.AppraisalVehicleMapper;
import com.factory.appraisal.vehiclesearchapp.persistence.mapper.ConfigCodesMapper;
import com.factory.appraisal.vehiclesearchapp.persistence.mapper.DealerRegistrationMapper;
import com.factory.appraisal.vehiclesearchapp.persistence.mapper.UserRegistrationMapper;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraiseVehicle;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EUserRegistration;
import com.factory.appraisal.vehiclesearchapp.repository.EAppraiseVehicleRepo;
import com.factory.appraisal.vehiclesearchapp.repository.EConfigurationCodesRepo;
import com.factory.appraisal.vehiclesearchapp.repository.EDealerRegistrationRepo;
import com.factory.appraisal.vehiclesearchapp.repository.EUserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EUserRegistrationServiceImpl implements EUserRegistrationService{

    @Autowired
    private EUserRegistrationRepo eUserRegistrationRepo;
    @Autowired
    private EConfigurationCodesRepo eConfigurationCodesRepo;
    @Autowired
    private EDealerRegistrationRepo eDealerRegistrationRepo;
    @Autowired
    private EAppraiseVehicleRepo eAppraiseVehicleRepo;

    @Autowired
    private UserRegistrationMapper userRegistrationMapper;
    @Autowired
    private AppraisalVehicleMapper appraisalVehicleMapper;
    @Autowired
    private DealerRegistrationMapper dealerRegistrationMapper;
    @Autowired
    private ConfigCodesMapper configCodesMapper;

    @Override
    public UserRegistration createUser(UserRegistration userRegistration) {
            EUserRegistration eUserRegistration=userRegistrationMapper.dtoToModel(userRegistration);
            EUserRegistration save=eUserRegistrationRepo.save(eUserRegistration);
        return userRegistrationMapper.modelToDto(save);
    }


      @Override
    public List<UserRegistration> getUsers() {
        List<EUserRegistration> getAll=eUserRegistrationRepo.findAll();
        return userRegistrationMapper.modelToDto(getAll);
    }

    @Override
    public UserRegistration updateUser(Long userId,UserRegistration userRegistration) {
        EUserRegistration users=eUserRegistrationRepo.findById(userId).get();
        if(users!=null){
            if(userRegistration.getValid()!=false) {
                if (userRegistration.getApartmentNumber() != null) {
                    users.setApartmentNumber(userRegistration.getApartmentNumber());
                }
                if (userRegistration.getCity() != null) {
                    users.setCity(userRegistration.getCity());
                }
                if (userRegistration.getEmail() != null) {
                    users.setEmail(userRegistration.getEmail());
                }
                if (userRegistration.getFirstName() != null) {
                    users.setFirstName(userRegistration.getFirstName());
                }
                if (userRegistration.getLastName() != null) {
                    users.setLastName(userRegistration.getLastName());
                }
                if (userRegistration.getPassword() != null) {
                    users.setPassword(userRegistration.getPassword());
                }
                if (userRegistration.getPhoneNumber() != null) {
                    users.setPhoneNumber(userRegistration.getPhoneNumber());
                }
                if (userRegistration.getState() != null) {
                    users.setState(userRegistration.getState());
                }
                if (userRegistration.getStreetAddress() != null) {
                    users.setStreetAddress(userRegistration.getStreetAddress());
                }
                if (userRegistration.getUserName() != null) {
                    users.setUserName(userRegistration.getUserName());
                }
                if (userRegistration.getZipCode() != null) {
                    users.setZipCode(userRegistration.getCity());
                }
            }

            }
            EUserRegistration save = eUserRegistrationRepo.save(users);
        return userRegistrationMapper.modelToDto(save);
    }

    @Override
    public String removeUserRegistration(Long userId) {
        eUserRegistrationRepo.deleteById(userId);
        return "deleted";
    }

    @Override
    public List<UserRegistration> GetUsersPageWise(Integer pageNo, Integer pageSize) {
        return null;
    }


}

