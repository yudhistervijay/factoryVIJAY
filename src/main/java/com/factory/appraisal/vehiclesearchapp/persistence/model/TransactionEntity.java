package com.factory.appraisal.vehiclesearchapp.persistence.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;


import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.sql.Date;


@MappedSuperclass
//@Inheritance
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity extends IdEntity {



    @CreatedBy
    private String createdBy;

    @CreatedDate
    private Date createdOn;


    @LastModifiedBy
    private String modifiedBy;

    @LastModifiedDate
    private Date modifiedOn;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
