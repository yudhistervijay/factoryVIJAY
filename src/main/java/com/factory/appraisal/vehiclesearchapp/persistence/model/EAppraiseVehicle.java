package com.factory.appraisal.vehiclesearchapp.persistence.model;
//@author:Rupesh Khade

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

import java.util.Date;


@Audited
@AuditTable(value = "APPRAISAL_VEHICLE_AUD", schema = "FACTORY_AUD")
@Entity
@Table(name = "APPRAISAL_VEHICLE",schema = "FACTORY_DB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@AttributeOverride(name = "appraisalReferenceId", column = @Column(name = "APPR_REF_ID"))
@AttributeOverride(name = "valid", column = @Column(name = "IS_ACTIVE"))
@AttributeOverride(name="createdBy",column =@Column(name = "CREATED_BY"))
@AttributeOverride(name="createdOn",column =@Column(name = "CREATED_ON"))
@AttributeOverride(name=" modifiedBy",column =@Column(name = "MODIFIED_BY"))
@AttributeOverride(name="modifiedOn",column =@Column(name = "MODIFIED_ON"))
public class EAppraiseVehicle extends TransactionEntity{
    @Id

    @GeneratedValue(generator = "APPR_VEH_SEQ")
    @GenericGenerator(
            name="APPR_VEH_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name="sequence_name",value = "FACTORY_DB.APPR_VEH_SEQ")
            })
    @Column(name="APPR_REF_ID")
    private Long appraisalReferenceId;

    @Column(name="APPR_RETENSION_TIME")
    private Date appraisalRetensionTime;
    @Column(name="APPR_VALUE")

    private String appraisalValue;
    @Column(name="BB_VALUE")

    private String blackBookValue;
    @Column(name="BRAKE_SYS_FUEL")

    private String brakeSystemFuel;

    @Column(name="E_SIGN_ID")
    private Long  eSignId;
    @Column(name="ENGINE_PERFORMANCE")

    private String enginePerformance;
    @Column(name="FIELD1")

    private String field1;
    @Column(name="FIELD2")

    private String field2;
    @Column(name="FIELD3")

    private String field3;
    @Column(name="LATITUDE")
    private String latitude;
    @Column(name="LONGITUDE")

    private String longitude;
    @Column(name="PROF_OPINION")

    private String professionalOpinion ;

    @Column(name = "STOCK_NUMBER")
    private Long stockNumber;
    @Column(name="TRANSMISSION")

    private String transmission ;
    @Column(name="MAKE")

    private String make ;
    @Column(name="MILES")

    private Long miles;
    @Column(name="MODEL")
    private String  model ;
    @Column(name="SERIES")
    private String  series;
    @Column(name="STYLE")
    private String  style;
    @Column(name="YEAR")
    private Long year;
    @Column(name="VIN_NUMBER ")
    private String vinNumber ;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(targetEntity = EDealerRegistration.class, fetch = FetchType.LAZY,cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "DEALER_ID",referencedColumnName = "DEALER_ID",nullable = false)
    private EDealerRegistration dealer;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(targetEntity = EUserRegistration.class, fetch = FetchType.LAZY,cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "USER_ID",referencedColumnName = "USER_ID",nullable = false)
    private EUserRegistration user;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(mappedBy = "appraisalRef",cascade = CascadeType.ALL)
    private EAppraisalTestDriveStatus appraisalTestDriveStatus;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(mappedBy = "appraisalReference")
     private ESignDet signDet;





}
