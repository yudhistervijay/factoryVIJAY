package com.factory.appraisal.vehiclesearchapp.persistence.mapper;
//@author:Rupesh Khade


import com.factory.appraisal.vehiclesearchapp.persistence.dto.ConfigurationCodes;
import com.factory.appraisal.vehiclesearchapp.persistence.dto.DealerRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EConfigurationCodes;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EDealerRegistration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ConfigCodesMapper  {
    DealerRegistrationMapper INSTANCE1 = Mappers.getMapper(DealerRegistrationMapper.class);

    @Mapping(target = "dealerRegistration",ignore = true)
    ConfigurationCodes modelToDto(EConfigurationCodes eConfigurationCodes);
    @Mapping(target ="dealerRegistration",expression = "java(mapDealerReg(configurationCodes.getDealerRegistration()))")
    EConfigurationCodes dtoToModel(ConfigurationCodes configurationCodes);

    default EDealerRegistration mapDealerReg(DealerRegistration dealerRegistrationDto){
        return INSTANCE1.dtoToModel(dealerRegistrationDto);
    }



}
