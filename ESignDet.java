package com.factory.appraisal.vehiclesearchapp.persistence.model;
//@Author:Yudhister vijay

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;

@Audited
@AuditTable(value = "E_SIGN_DET_AUD" , schema = "FACTORY_AUD")
@Entity
@Table(name = "E_SIGN_DET",schema = "FACTORY_DB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@AttributeOverride(name = "signId", column = @Column(name = "E_SIGN_ID"))
@AttributeOverride(name = "valid", column = @Column(name = "IS_ACTIVE"))
@AttributeOverride(name = "createdBy", column = @Column(name = "CREATED_BY"))
@AttributeOverride(name = "createdOn", column = @Column(name = "CREATED_ON"))
@AttributeOverride(name = "modifiedBy", column = @Column(name = "MODIFIED_BY"))
@AttributeOverride(name = "modifiedOn", column = @Column(name = "MODIFIED_ON"))
public class ESignDet extends TransactionEntity{


    @Id
    @Column(name="E_SIGN_ID")
    @GeneratedValue(strategy= GenerationType.SEQUENCE ,generator = "e_sign_det_seq")
    @SequenceGenerator(name = "e_sign_det_seq" , sequenceName = "E_SIGN_DET_SEQ")
    private Long signId;
    @Column(name = "E_SIGN_DOC")
    private String signDocument;

    @OneToOne(targetEntity = EAppraiseVehicle.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "APPR_REF_ID",referencedColumnName = "APPR_REF_ID", nullable = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private EAppraiseVehicle appraisalReferenceId;
    

}
