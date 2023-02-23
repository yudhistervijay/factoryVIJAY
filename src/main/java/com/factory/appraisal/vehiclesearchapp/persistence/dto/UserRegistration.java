package com.factory.appraisal.vehiclesearchapp.persistence.dto;
//@Author:Yudhister vijay


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistration extends TransactionEntity{
    private Long userId;

    @Size(max = 10)
    private String apartmentNumber;


    @NotNull(message = "city should not be null")
    @Size(max = 10)
    private String city;
    @NotNull(message = "email should not be null")
    @Email(message = "invalid email id")
    @Size(max = 50)
    private String email;
    @NotNull(message = "FirstName should not be null")
    @Size(max = 15 ,message = "maximum size of firstName 15")
    private String firstName;
    @NotNull(message = "LastName should not be null")
    @Size(max = 15,message = "the maximum length is 15 only")
    private String lastName;
    @NotNull(message = "password should not be null")
    @Size(max = 20, message = "the maximum length is 20 only")
    private String password;
    @NotNull(message = "phoneNumber should not be null")
    @Size(max = 13, message = "give 13 digit American phone number with +1 code sample example:+1 5551234567")
    @Pattern(regexp = "^\\+1\\s\\(?\\d{3}\\)?[- ]?\\d{3}[- ]?\\d{4}$")
    /* Some valid examples of phone numbers
    +1 5551234567     */
    private String phoneNumber;
    @NotNull(message = "state should not be null")
    @Size(max = 10 , message = "the maximum size of state is 10 characters only")
    private String state;
    @NotNull(message = "streetAddress should not be null")
    @Size(max = 50,message = "the maximum length is 50 only")
    private String streetAddress;
    @NotNull(message = "userName should not be null")
    @Size(max = 30,message = "the maximum length is 30 only")
    private String userName;
    @NotNull(message = "zipcode should not be null")
    @Size(max = 5,message = "the maximum length is 5 only")
    private String zipCode;


    private ConfigurationCodes roleConfig;

    private DealerRegistration dealer;

}