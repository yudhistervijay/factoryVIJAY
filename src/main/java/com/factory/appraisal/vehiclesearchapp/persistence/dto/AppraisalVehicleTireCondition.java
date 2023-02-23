package com.factory.appraisal.vehiclesearchapp.persistence.dto;

import com.factory.appraisal.vehiclesearchapp.persistence.model.TransactionEntity;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppraisalVehicleTireCondition extends TransactionEntity {
    @Size(max = 15)
    private long vehicleTireConditionId;
    @NotNull
    private boolean tireWidth;
    @NotNull
    private boolean fourMatch;
    @NotNull
    private boolean mismatched;
    @NotNull
    private boolean excellentTread;
    @NotNull
    private boolean goodTread;
    @NotNull
    private boolean poorTread;
    @NotNull
    private boolean needsReplacement;
    @NotNull
    private boolean frontUnevenWearPattern;
    @NotNull
    private boolean frontTiresBad;
    @NotNull
    private boolean rearTiresBad;
    @NotNull
    private boolean noSpareTire;
    @NotNull
    private boolean spareTireOnVehicle;
    private AppraisalTestDriveStatus vehicleStatus;
}