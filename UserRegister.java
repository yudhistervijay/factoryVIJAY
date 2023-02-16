package com.factory.appraisal.vehiclesearchapp.dto;
//@Author:Yudhister vijay

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegister extends TransactionEntityDto{

    @Size(max = 10)
    private String apartmentNumber;
    @NotNull
    @Size(max = 10)
    private String city;
    @NotNull
    @Email(message = "invalid email id")
    @Size(max = 50)
    private String email;
    @NotNull
    @Size(max = 15)
    private String firstName;
    @NotNull
    @Size(max = 15)
    private String lastName;
    @NotNull
    @Size(max = 20)
    private String password;
    @NotNull
    @Size(max = 13)
    @Pattern(regexp = "^\\+1\\s\\(?\\d{3}\\)?[- ]?\\d{3}[- ]?\\d{4}$")
    /* Some valid examples of phone numbers
    +1 (555) 123-4567
    +1 555 123-4567
    +1 5551234567     */
    private String phoneNumber;
    @NotNull
    @Size(max = 10)
    private String state;
    @NotNull
    @Size(max = 50)
    private String streetAddress;
    @NotNull
    @Size(max = 30)
    private String userName;
    @NotNull
    @Size(max = 5)
    private String zipCode;
    
    
    private ConfigurationCodes roleId;
    
    private DealerRegistration dealerId;

}
