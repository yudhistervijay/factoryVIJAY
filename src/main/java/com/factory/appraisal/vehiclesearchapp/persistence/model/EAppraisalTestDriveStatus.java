package com.factory.appraisal.vehiclesearchapp.persistence.model;
//@author:Rupesh Khade

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
@Audited
@AuditTable(value = "APR_TEST_DR_STATUS_AUD", schema = "FACTORY_AUD")
@Entity
@Table(name = "APR_TEST_DR_STATUS",schema = "FACTORY_DB")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@AttributeOverride(name = "vehicleDivingStatusId", column = @Column(name = "VEH_STATUS_ID "))
@AttributeOverride(name = "valid", column = @Column(name = "IS_ACTIVE"))
@AttributeOverride(name="createdBy",column =@Column(name = "CREATED_BY"))
@AttributeOverride(name="createdOn",column =@Column(name = "CREATED_ON"))
@AttributeOverride(name=" modifiedBy",column =@Column(name = "MODIFIED_BY"))
@AttributeOverride(name="modifiedOn",column =@Column(name = "MODIFIED_ON"))

public class EAppraisalTestDriveStatus extends TransactionEntity{
    @Id
    @GeneratedValue(generator = "APR_TEST_DR_STATUS_SEQ")
    @GenericGenerator(
            name="APR_TEST_DR_STATUS_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name="sequence_name",value = "FACTORY_DB.APR_TEST_DR_STATUS_SEQ")
            })
    @Column(name = "VEH_STATUS_ID")
    private Long vehicleDivingStatusId;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(targetEntity = EAppraiseVehicle.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "APPRAISAL_REF ",referencedColumnName = "APPR_REF_ID",nullable = false)
    private EAppraiseVehicle appraisalRef;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(mappedBy = "vehicleStatus")
    private EAppraisalVehicleAcCondition appraisalVehicleAcCondition;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(mappedBy = "vehicleStatus")
    private EAppraisalVehicleInteriorCondition appraisalVehicleInteriorCondition;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(mappedBy = "vehicleStatus")
    private EAppraisalVehicleOilCondition appraisalVehicleOilCondition;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(mappedBy = "vehicleStatus")
    private EAppraisalVehicleStereoStatus appraisalVehicleStereoStatus;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(mappedBy = "vehicleStatus")
    private EAppraisalVehicleTireCondition appraisalVehicleTireCondition;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(mappedBy = "vehicleStatus")
    private EVehicleDrivingWarnLightStatus vehicleDrivingWarnLightStatus;


    @Column(name = "OPT_EQUIPMENT")
    private String optionalEquipment;
    @Column(name = "ENGINE_TYPE")
    private String  engineType;
    @Column(name = "TRANSMISSION_TYPE ")
    private String transmissionType;
    @Column(name = " STEERING")
    private String steering;
    @Column(name = "DR_LOCK_TYPE")
    private String doorLockType;
    @Column(name = "F_L_IMAGE")
    private String  frontLeftSideImage;
    @Column(name = "F_L_WIN_STATUS ")
    private String frontLeftWindowStatus;
    @Column(name = "F_R_WIN_STATUS")
    private String  frontRightWindowStatus;
    @Column(name = "R_L_WIN_STATUS ")
    private String  rearLeftWindowStatus;
    @Column(name = "R_R_WIN_STATUS")
    private String   rearRightWindowStatus;
    @Column(name = "F_R_IMAGE")
    private String frontRightImage;
    @Column(name = "R_L_IMAGE")
    private String   rearLeftImage;
    @Column(name = "R_R_IMAGE ")
    private String rearRightImage;
    @Column(name = "INTR_TYPE")
    private String interiorType;
    @Column(name = "LIGHT_CONDN ")
    private String lightCondition;
    @Column(name = "ROOF_TYPE")
    private String roofType;
    @Column(name = "APR_FOLLOW_UP ")
    private String appraisalFollowUp;
    @Column(name = "APR_INV_STATUS ")
    private String appraisalInventoryStatus;
    @Column(name = "EXTR_COLOR")
    private String exteriorColor;
    @Column(name = "EXTR_DMG_STATUS ")
    private String exteriorDamageStatus;
    @Column(name = "F_DR_SIDE_DMG_DESC")
    private String frontDriverSideDamageDescription;
    @Column(name = "F_DR_SIDE_DMG_STS")
    private String frontDriverSideDamageStatus;
    @Column(name = "F_P_SIDE_DMG_DESC")
    private String frontPassengerSideDamageDescription;
    @Column(name = "F_P_SIDE_DMG_STS ")
    private String frontPassengerSideDamageStatus;


    @Column(name = "PNTWRK_FD_SIDE_STS ")
    private String paintWorkFrontDriverSideStatus;
    @Column(name = "PNTWRK_FD_SIDE_STS_DESC")
    private String paintWorkFrontDriverSideStatusDescription;
    @Column(name = "PNTWRK_FP_SIDE_STS")
    private String paintWorkFrontPassengerSideStatus;
    @Column(name = "PNTWRK_FP_SIDE_STS_DESC")
    private String paintWorkFrontPassengerSideStatusDescription;
    @Column(name = "PNTWRK_RD_SIDE_STS")
    private String paintWorkRearDriverSideStatus;
    @Column(name = "PNTWRK_RD_SIDE_STS_DESC")
    private String paintWorkRearDriverSideStatusDescription;
    @Column(name = "PNTWRK_RP_SIDE_STS")
    private String paintWorkRearPassengerSideStatus;
    @Column(name = "PNTWRK_RP_SIDE_STS_DESC")
    private String paintWorkRearPassengerSideStatusDescription;
    @Column(name = "PNTWRK_STATUS")
    private String paintWorkStatus;
    @Column(name = "R_DR_SIDE_DMG_DESC")
    private String rearDriverSideDamageDescription;
    @Column(name = "R_DR_SIDE_DMG_STS ")
    private String  rearDriverSideDamageStatus;
    @Column(name = "R_PASS_SIDE_DMG_DESC")
    private String rearPassengerSideDamageDescription;
    @Column(name = "R_PASS_SIDE_DMG_STS ")
    private String rearPassengerSideDamageStatus;
    @Column(name = "WS_BUY_FIG_STS ")
    private String wholesaleBuyFiguresStatus;
    @Column(name = "WIND_SHIELD_DMG")
    private String windshieldDamage;



}