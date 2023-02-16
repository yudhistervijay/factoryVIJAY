package com.factory.appraisal.vehiclesearchapp.dto;
//@Author:Yudhister vijay

import com.factory.appraisal.vehiclesearchapp.persistence.model.EAppraiseVehicle;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignDet {
    @NotNull
    @Size(max = 17)
    private String signDocument;
//    @NotNull
//    @Size(max = 15)
//    private AppraiseVehicle appraisalReferenceId;


}
