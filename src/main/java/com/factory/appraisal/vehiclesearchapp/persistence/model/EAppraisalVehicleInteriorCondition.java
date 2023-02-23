package com.factory.appraisal.vehiclesearchapp.persistence.model;
//author:Kalyan Dey

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;

@Audited
@AuditTable(value = "APR_VEH_INTR_CONDN_AUD",schema = "FACTORY_AUD")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="APR_VEH_INTR_CONDN", schema = "FACTORY_DB")
@DynamicUpdate
@DynamicInsert
@AttributeOverride(name = "interiorConditionId", column = @Column(name = "INTR_CONDN_ID"))
@AttributeOverride(name = "createdBy", column = @Column(name = "CREATED_BY"))
@AttributeOverride(name = "createdOn", column = @Column(name = "CREATED_ON"))
@AttributeOverride(name = "modifiedBy", column = @Column(name = "MODIFIED_BY"))
@AttributeOverride(name = "modifiedOn", column = @Column(name = "MODIFIED_ON"))
@AttributeOverride(name = "valid", column = @Column(name = "IS_ACTIVE"))
public class EAppraisalVehicleInteriorCondition extends TransactionEntity{
    @Id
    @GeneratedValue(generator = "APR_VEH_INTR_CONDN_SEQ")
    @GenericGenerator(
            name="APR_VEH_INTR_CONDN_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name="sequence_name",value = "FACTORY_DB.APR_VEH_INTR_CONDN_SEQ")
            })
    @Column(name = "INTR_CONDN_ID")
    private Long interiorConditionId ;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(targetEntity = EAppraisalTestDriveStatus.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "VEH_STATUS_ID",referencedColumnName = "VEH_STATUS_ID",nullable = false)
    private EAppraisalTestDriveStatus vehicleStatus;

    @Column(name = "CLEAN_FL")
    private boolean cleanFrontlineReady ;
    @Column(name = "GOOD_MNR_RPR_ND")
    private boolean goodMinorRepairsNeeded ;
    @Column(name = "SMOKERS_CAR")
    private boolean smokersCar ;
    @Column(name = "ODD_SMELL")
    private boolean oddSmelling ;
    @Column(name = "VERY_DIRTY")
    private boolean veryDirty ;
    @Column(name = "STG_PET_SMELL")
    private boolean strongPetSmell ;
    @Column(name = "DRV_SEAT_WEAR")
    private boolean driversSeatWear ;
    @Column(name = "HL_NEED_RPLC")
    private boolean headlinearNeedReplacement ;
    @Column(name = "DRV_SEAT_RIPPED")
    private boolean driverSeatRipped;

    @Column(name = "DASH_CRACKED_MNR")
    private boolean dashCrackedMinor ;
    @Column(name = "DASH_CRK_BRKN_MAJ")
    private boolean dashCrackedBrokenMajor ;
    @Column(name = "PAX_SEAT_RIPPED")
    private boolean passengerSeatRipped ;
    @Column(name = "CARPET_BADLY_WORN")
    private boolean carpetBadlyWorn ;
    @Column(name = "INT_TRIM_BRKN_MS")
    private boolean interiorTrimBrokenMissing ;
    @Column(name = "POOR_NEEDS_RPR")
    private boolean poorNeedsRepair ;
}
