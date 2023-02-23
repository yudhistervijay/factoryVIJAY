package com.factory.appraisal.vehiclesearchapp;

import com.factory.appraisal.vehiclesearchapp.ConfigClass.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
/*import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;*/

//@EnableElasticsearchRepositories(basePackages = "com.factory.appraisal.vehiclesearchapp.repository")
@ComponentScan(basePackages = { "com.factory.appraisal.vehiclesearchapp" })
@SpringBootApplication
public class VehiclesearchappApplication {


	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(VehiclesearchappApplication.class, args);
		AppConfig appConfig=context.getBean(AppConfig.class);

		System.out.println(appConfig.getMainSchemaName()+"==============");
		System.out.println(appConfig.getAuditSchemaName()+"===============");


	}

}
