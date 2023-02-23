package com.factory.appraisal.vehiclesearchapp.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppraisalVehicleOilCondition {

    @NotNull
    @Max(15)
    private long vehicleOilConditionId;

    private AppraisalTestDriveStatus vehicleStatus;
    @NotNull
    private boolean cleanOil ;
    @NotNull
    private boolean dirtyOil ;
    @NotNull
    private boolean waterInOil;
    @NotNull
    private boolean correctLevel ;
    @NotNull
    private boolean  oneQuartLow ;
    @NotNull
    private boolean moreThanAQuartLow ;
    @NotNull
    private boolean electronicGauge ;


}