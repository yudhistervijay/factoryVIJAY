package com.factory.appraisal.vehiclesearchapp.persistence.dto;
//@Author:Yudhister vijay

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignDet extends TransactionEntity{
    private Long signId;
    @NotNull(message = "sign Document should not be null")
    @Size(max = 17 , message = "maximum size of signDocument is 17")
    private String signDocument;

    private AppraiseVehicle appraisalReference;


}