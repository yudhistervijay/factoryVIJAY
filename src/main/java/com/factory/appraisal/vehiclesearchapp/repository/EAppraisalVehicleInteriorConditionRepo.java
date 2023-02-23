package com.factory.appraisal.vehiclesearchapp.repository;

import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraisalVehicleInteriorCondition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EAppraisalVehicleInteriorConditionRepo extends CrudRepository<EAppraisalVehicleInteriorCondition,Long> {
}
