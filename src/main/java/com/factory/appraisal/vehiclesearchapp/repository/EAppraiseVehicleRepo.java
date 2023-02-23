package com.factory.appraisal.vehiclesearchapp.repository;
//Author:Rupesh khade
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraiseVehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EAppraiseVehicleRepo extends CrudRepository<EAppraiseVehicle,Long> {
    public EAppraiseVehicle findByVinNumber(String vinNum);

}
