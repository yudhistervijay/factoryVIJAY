package com.factory.appraisal.vehiclesearchapp.persistence.mapper;
//author:yudhister vijay


import com.factory.appraisal.vehiclesearchapp.persistence.dto.ConfigurationCodes;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.DealerRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.UserRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EConfigurationCodes;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EDealerRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EUserRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRegistrationMapper {

    DealerRegistrationMapper INSTANCE1 = Mappers.getMapper(DealerRegistrationMapper.class);
    ConfigCodesMapper INSTANCE2 = Mappers.getMapper(ConfigCodesMapper.class);
    @Mapping(target = "roleConfig",ignore = true)
    @Mapping(target = "dealer",ignore = true)
    UserRegistration modelToDto( EUserRegistration eUserRegistration);
    @Mapping(target = "roleConfig",expression = "java(mapConfigCodes(userRegistration.getRoleConfig()))")
    @Mapping(target = "dealer",expression = "java(mapDealerReg(userRegistration.getDealer()))")
    EUserRegistration dtoToModel( UserRegistration userRegistration);


    default EDealerRegistration mapDealerReg(DealerRegistration dealerRegistrationDto){
        return INSTANCE1.dtoToModel(dealerRegistrationDto);
    }

    default EConfigurationCodes mapConfigCodes(ConfigurationCodes configurationCodesDto){
        return INSTANCE2.dtoToModel(configurationCodesDto);
    }

    List<UserRegistration> modelToDto(List<EUserRegistration> eUserRegistrationList);


}
