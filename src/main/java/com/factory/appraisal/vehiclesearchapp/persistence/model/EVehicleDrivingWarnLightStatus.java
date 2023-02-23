package com.factory.appraisal.vehiclesearchapp.persistence.model;
//@Author:Yudhister vijay

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.annotations.Parameter;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;

@Audited
@AuditTable(value = "VEH_D_WARN_LIGHT_STATUS_AUD" , schema = "FACTORY_AUD")
@Entity
@Table(name = "VEH_D_WARN_LIGHT_STATUS",schema = "FACTORY_DB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@AttributeOverride(name = "warningLightStatusId", column = @Column(name = "WL_STATUS_ID"))
@AttributeOverride(name = "valid", column = @Column(name = "IS_ACTIVE"))
@AttributeOverride(name = "createdBy", column = @Column(name = "CREATED_BY"))
@AttributeOverride(name = "createdOn", column = @Column(name = "CREATED_ON"))
@AttributeOverride(name = "modifiedBy", column = @Column(name = "MODIFIED_BY"))
@AttributeOverride(name = "modifiedOn", column = @Column(name = "MODIFIED_ON"))
public class EVehicleDrivingWarnLightStatus extends TransactionEntity{

    @Id
    @Column(name = "WL_STATUS_ID")
    @GeneratedValue(generator = "VEH_D_WARN_LIGHT_STATUS_SEQ")
    @GenericGenerator(
            name="VEH_D_WARN_LIGHT_STATUS_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name="sequence_name",value = "FACTORY_DB.VEH_D_WARN_LIGHT_STATUS_SEQ")
            })
    private Long warningLightStatusId;

    @OneToOne(targetEntity = EAppraisalTestDriveStatus.class, fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "VEH_STATUS_ID",referencedColumnName = "VEH_STATUS_ID", nullable = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private EAppraisalTestDriveStatus vehicleStatus;
    @Column(name = "NO_FAULTS")
    private boolean noFaults;
    @Column(name = "ABS_LIGHT")
    private boolean absLight;
    @Column(name = "AIRBAG_FAULT")
    private boolean airBagFault;
    @Column(name = "BATTERY_FAULT")
    private boolean batteryFault;
    @Column(name = "BRAKE_SYSTEM")
    private boolean brakeSystem;
    @Column(name = "BRAKE_PAD_WEAR")
    private boolean brakePadWear;
    @Column(name = "CHARGING_SYS")
    private boolean chargingSystem;
    @Column(name = "COOLANT_LEVEL")
    private boolean coolantLevel;
    @Column(name = "COOLANT_TEMP")
    private boolean coolantTemp;
    @Column(name = "CHECK_ENG_LIGHT")
    private boolean checkEngineLight;
    @Column(name = "OIL_PRESSURE")
    private boolean oilPressure;
    @Column(name = "SERVICE_ENG_SOON")
    private boolean serviceEngineSoon;
    @Column(name = "STEERING_FAULTS")
    private boolean steeringFaults;
    @Column(name = "SUSPENSION_SYSTEM")
    private boolean suspensionSystem;
    @Column(name = "TRACTION_CONTROL")
    private boolean tractionControl;
    @Column(name = "TRANSMISSION_FAULT")
    private boolean transmissionFault;
    @Column(name = "DEF_LIGHT")
    private boolean dieselExhaustFluidLight;
    @Column(name = "DPF_LIGHT")
    private boolean dieselParticulateFilter;



}