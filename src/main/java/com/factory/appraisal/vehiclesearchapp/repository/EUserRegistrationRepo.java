package com.factory.appraisal.vehiclesearchapp.repository;
//Author:yudhister vijay
import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraiseVehicle;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EUserRegistration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EUserRegistrationRepo extends JpaRepository<EUserRegistration,Long> {

//    Page<EUserRegistration> findAllByUsersIsTrueOrderByCreatedOnDesc(Pageable pageable);
}
