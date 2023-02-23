package com.factory.appraisal.vehiclesearchapp.persistence.model;
// authorName : YogeshKumarV,Rupesh Khade

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;



import javax.persistence.*;
import java.sql.Date;

@Audited
@AuditTable(value = "CONFIG_CODES_AUD",schema = "FACTORY_AUD")
//@AuditTable(value = "CONFIG_CODES_AUD",schema = "${audit.schema.name}")                        //#{@environment.getProperty('mySchema')}
@Entity
@Table(name = "CONFIG_CODES",schema = "FACTORY_DB")
//@Table(name = "CONFIG_CODES",schema = "${main.schema.name}")
//@Table(name = "CONFIG_CODES", indexes = {
//        @Index(name = "CONFIG_CODES_CODE_TYPE_IDX", columnList = "CODE_TYPE, SHORT_CODE",unique = true,options = @IndexOptions(name = "CONFIG_CODES_CODE_TYPE_IDX", value = " TS_FACTORY_DB_IDX")),
//        @Index(name = "CONFIG_CODES_IS_ACTIVE_IDX", columnList = "IS_ACTIVE")
//},schema = "FACTORY_DB")
@DynamicUpdate
@DynamicInsert
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverride(name = "createdBy", column = @Column(name = "CREATED_BY"))
@AttributeOverride(name = "createdOn", column = @Column(name = "CREATED_ON"))
@AttributeOverride(name = "modifiedBy", column = @Column(name = "MODIFIED_BY"))
@AttributeOverride(name = "modifiedOn", column = @Column(name = "MODIFIED_ON"))
@AttributeOverride(name = "valid", column = @Column(name = "IS_ACTIVE"))
public class EConfigurationCodes extends TransactionEntity{




@Id
@Column(name = "CODE_ID")
@GeneratedValue(generator = "config_codes_seq")
@GenericGenerator(
        name="config_codes_seq",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name="sequence_name",value = "FACTORY_DB.config_codes_seq")
        })
    private Long codeId;
    private String codeType;
    private String shortCode;
    private String longCode;
    private String shortDescription;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(mappedBy="configCodes")
    private EDealerRegistration dealerRegistration;

}