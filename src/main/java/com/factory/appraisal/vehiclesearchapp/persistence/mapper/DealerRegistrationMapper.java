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
public interface DealerRegistrationMapper {

    ConfigCodesMapper INSTANCE = Mappers.getMapper(ConfigCodesMapper.class);
    @Mapping(target = "configCodes",ignore = true)
    DealerRegistration modeltoDto(EDealerRegistration eDealerRegistration);
    @Mapping(target = "configCodes",expression = "java(mapConfigCodes(dealerRegistration.getConfigCodes()))")
    EDealerRegistration dtoToModel(DealerRegistration dealerRegistration);

    default EConfigurationCodes mapConfigCodes(ConfigurationCodes configurationCodesDto){
        return INSTANCE.dtoToModel(configurationCodesDto);
    }




}
