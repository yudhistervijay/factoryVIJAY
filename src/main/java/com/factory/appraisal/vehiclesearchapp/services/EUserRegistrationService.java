package com.factory.appraisal.vehiclesearchapp.services;
//Author:yudhister vijay
import com.factory.appraisal.vehiclesearchapp.persistence.dto.AppraiseVehicle;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.UserRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EUserRegistration;

import java.util.List;

public interface EUserRegistrationService {
     UserRegistration createUser(UserRegistration userRegistration);
    List<UserRegistration> getUsers();
    UserRegistration updateUser(Long userId ,UserRegistration userRegistration);
    String removeUserRegistration(Long userId);
    List<UserRegistration> GetUsersPageWise(Integer pageNo, Integer pageSize);


}
