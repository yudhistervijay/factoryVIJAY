package com.factory.appraisal.vehiclesearchapp.ConfigClass;
//@author:Rupesh Khade
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${main.schema.name}")
    private  String mainSchemaName;

    @Value("${audit.schema.name}")
    private String auditSchemaName;






}