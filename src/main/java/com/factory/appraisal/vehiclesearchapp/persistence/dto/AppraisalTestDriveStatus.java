package com.factory.appraisal.vehiclesearchapp.persistence.dto;
//@author:Rupesh khade


import com.factory.appraisal.vehiclesearchapp.persistence.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppraisalTestDriveStatus extends TransactionEntity {

    private Long vehicleDivingStatusId;
    private AppraiseVehicle appraisalRef;

    private AppraisalVehicleAcCondition appraisalVehicleAcCondition;

    private AppraisalVehicleInteriorCondition appraisalVehicleInteriorCondition;
    private AppraisalVehicleOilCondition appraisalVehicleOilCondition;
    private AppraisalVehicleStereoStatus appraisalVehicleStereoStatus;
    private AppraisalVehicleTireCondition appraisalVehicleTireCondition;
    private VehicleDrivingWarnLightStatus vehicleDrivingWarnLightStatus;


    @Max(50)
    private String optionalEquipment;
    @Max(4)
    @NotNull
    private String  engineType;
    @Max(10)
    @NotNull
    private String transmissionType;
    @Max(5)
    @NotNull
    private String steering;
    @Max(30)
    private String doorLockType;
    @Max(17)
    private String  frontLeftSideImage;
    @Max(15)
    @NotNull
    private String frontLeftWindowStatus;
    @Max(15)
    @NotNull
    private String   frontRightWindowStatus;
    @Max(15)
    @NotNull
    private String  rearLeftWindowStatus;
    @Max(15)
    @NotNull
    private String  rearRightWindowStatus;
    @Max(17)
    @NotNull
    private String frontRightImage;
    @Max(17)
    @NotNull
    private String  rearLeftImage;
    @Max(17)
    @NotNull
    private String rearRightImage;
    @Max(30)
    @NotNull
    private String interiorType;
    @Max(30)
    private String lightCondition;
    @Max(50)
    private String roofType;
    @Max(10)
    private String appraisalFollowUp;
    @Max(10)
    private String appraisalInventoryStatus;
    @Max(10)
    private String exteriorColor;
    @Max(50)
    private String exteriorDamageStatus;
    @Max(50)
    private String frontDriverSideDamageDescription;
    @Max(50)
    private String frontDriverSideDamageStatus;
    @Max(50)
    private String frontPassengerSideDamageDescription;
    @Max(50)
    private String frontPassengerSideDamageStatus;

    // private String optionalEquipment;
    @Max(50)
    private String paintWorkFrontDriverSideStatus;
    @Max(50)
    private String paintWorkFrontDriverSideStatusDescription;
    @Max(50)
    private String paintWorkFrontPassengerSideStatus;
    @Max(50)
    private String paintWorkFrontPassengerSideStatusDescription;
    @Max(50)
    private String paintWorkRearDriverSideStatus;
    @Max(50)
    private String paintWorkRearDriverSideStatusDescription;
    @Max(50)
    private String paintWorkRearPassengerSideStatus;
    @Max(50)
    private String paintWorkRearPassengerSideStatusDescription;
    @Max(50)
    private String paintWorkStatus;
    @Max(50)
    private String rearDriverSideDamageDescription;
    @Max(50)
    private String rearDriverSideDamageStatus;
    @Max(50)
    private String rearPassengerSideDamageDescription;
    @Max(50)
    private String rearPassengerSideDamageStatus;
    @Max(50)
    private String wholesaleBuyFiguresStatus;
    @Max(50)
    private String windshieldDamage;




}
