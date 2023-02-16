package com.factory.appraisal.vehiclesearchapp.persistence.model;
//@Author: Yudhister vijay
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
@AuditTable(value = "USER_REG_AUD" , schema = "FACTORY_AUD")
@Entity
@Table(name = "USER_REG",schema = "FACTORY_DB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@AttributeOverride(name = "userId", column = @Column(name = "USER_ID"))
@AttributeOverride(name = "valid", column = @Column(name = "IS_ACTIVE"))
@AttributeOverride(name = "createdBy", column = @Column(name = "CREATED_BY"))
@AttributeOverride(name = "createdOn", column = @Column(name = "CREATED_ON"))
@AttributeOverride(name = "modifiedBy", column = @Column(name = "MODIFIED_BY"))
@AttributeOverride(name = "modifiedOn", column = @Column(name = "MODIFIED_ON"))
public class EUserRegister extends TransactionEntity{
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy= GenerationType.SEQUENCE ,generator = "user_reg_seq")
    @SequenceGenerator(name = "user_reg_seq" , sequenceName = "USER_REG_SEQ")
    private Long userId;
    @Column(name = "APT_NUMBER")
    private String apartmentNumber;
    private String city;
    private String email;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    private String password;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    private String state;
    @Column(name = "STREET_ADDRESS")
    private String streetAddress;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "ZIP_CODE")
    private String zipCode;

    @OneToOne(targetEntity = EConfigurationCodes.class, fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "CODE_ID", nullable = false)
    private EConfigurationCodes roleId;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(targetEntity = EDealerRegistration.class, fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "DEALER_ID", referencedColumnName = "DEALER_ID",nullable = false)
    @Column(name = "DEALER_ID")
    private EDealerRegistration dealerId;
    

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(mappedBy = "userId")
    private EAppraiseVehicle appraiseVehicle;



}
