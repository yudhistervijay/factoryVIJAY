package com.factory.appraisal.vehiclesearchapp.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
/*import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;*/

import javax.persistence.*;
/*import java.sql.Date;*/


@MappedSuperclass
//@Inheritance
@NoArgsConstructor
@AllArgsConstructor
public class IdEntity {

  /* @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    @Column(name = "id")
    private Long id;*/


    private Boolean valid;

   /* public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
