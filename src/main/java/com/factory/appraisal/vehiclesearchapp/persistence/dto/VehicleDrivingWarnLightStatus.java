package com.factory.appraisal.vehiclesearchapp.persistence.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VehicleDrivingWarnLightStatus extends TransactionEntity {

    private AppraisalTestDriveStatus vehicleStatus;
    @NotNull(message = "noFaults should not be null")
    private boolean noFaults;
    @NotNull(message = "absLight should not be null")
    private boolean absLight;
    @NotNull(message = "airBagFault should not be null")
    private boolean airBagFault;
    @NotNull(message = "batteryFault should not be null")
    private boolean batteryFault;
    @NotNull(message = "brakeSystem should not be null")
    private boolean brakeSystem;
    @NotNull(message = "brakePadWear should not be null")
    private boolean brakePadWear;
    @NotNull(message = "chargingSystem should not be null")
    private boolean chargingSystem;
    @NotNull(message = "coolantLevel should not be null")
    private boolean coolantLevel;
    @NotNull(message = "coolantTemp should not be null")
    private boolean coolantTemp;
    @NotNull(message = "checkEngineLight should not be null")
    private boolean checkEngineLight;
    @NotNull(message = "oilPressure should not be null")
    private boolean oilPressure;
    @NotNull(message = "serviceEngineSoon should not be null")
    private boolean serviceEngineSoon;
    @NotNull(message = "steeringFaults should not be null")
    private boolean steeringFaults;
    @NotNull(message = "suspensionSystem should not be null")
    private boolean suspensionSystem;
    @NotNull(message = "tractionControl should not be null")
    private boolean tractionControl;
    @NotNull(message = "transmissionFault should not be null")
    private boolean transmissionFault;
    @NotNull(message = "dieselExhaustFluidLight should not be null")
    private boolean dieselExhaustFluidLight;
    @NotNull(message = "dieselParticularFilter should not be null")
    private boolean dieselParticulateFilter;

}
