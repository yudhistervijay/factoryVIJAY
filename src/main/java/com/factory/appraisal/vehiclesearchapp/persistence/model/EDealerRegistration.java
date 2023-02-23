package com.factory.appraisal.vehiclesearchapp.persistence.model;
// authorName:YogeshKumarV


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.annotations.Parameter;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;

@Audited
@AuditTable(value = "DEALER_REG_AUD",schema = "FACTORY_AUD")
@Entity
@Table(name = "DEALER_REG",schema = "FACTORY_DB")
@DynamicUpdate
@DynamicInsert
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverride(name = "createdBy", column = @Column(name = "CREATED_BY"))
@AttributeOverride(name = "createdOn", column = @Column(name = "CREATED_ON"))
@AttributeOverride(name = "modifiedBy", column = @Column(name = "MODIFIED_BY"))
@AttributeOverride(name = "modifiedOn", column = @Column(name = "MODIFIED_ON"))
@AttributeOverride(name = "valid", column = @Column(name = "IS_ACTIVE"))
public class EDealerRegistration extends TransactionEntity{
    @Id
    @Column(name="DEALER_ID")
    @GeneratedValue(generator = "DEALER_REG_SEQ")
    @GenericGenerator(
            name="DEALER_REG_SEQ",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name="sequence_name",value = "FACTORY_DB.DEALER_REG_SEQ ")
            })
    private  long dealerId;
    private String name;
    private String firstName;
    private String lastName;
    @Column(name ="APT_NUMBER")
    private String ApartmentNumber;
    private String city;
    private String email;
    private String password;
    private String phoneNumber;
    @Column(name = "PROFILE_PIC")
    private String profilePicture;
    private String state;
    private String streetAddress;
    private String zipCode;
    private String latitude;
    private String longitude;
    @Column(name = "TAX_CERT")
    private String taxCertificate;
    @Column(name = "DS_NAME")
    private String dealershipName;
    @Column(name = "DS_ADDR")
    private String dealershipAddress;
    @Column(name = "DS_STREET")
    private String dealershipStreet;
    @Column(name = "DS_CITY")
    private String dealershipCity;
    @Column(name = "DS_ZIP_CODE")
    private String dealershipZipCode;
    @Column(name = "DS_PHONE_NO")
    private String dealershipPhoneNumber;
    @Column(name = "DS_PIC")
    private String dealershipPicture;
    @Column(name = "DS_LIC")
    private String dealershipLicense;
    @Column(name = "CORP_NAME")
    private String corporationName;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(targetEntity = EConfigurationCodes.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "CODE_ID",nullable = false,referencedColumnName = "CODE_ID")
    private EConfigurationCodes configCodes;
}