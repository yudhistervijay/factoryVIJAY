package com.factory.appraisal.vehiclesearchapp.controller;
//Author:yudhister vijay
import com.factory.appraisal.vehiclesearchapp.persistence.dto.UserRegistration;
import com.factory.appraisal.vehiclesearchapp.persistence.model.EUserRegistration;
import com.factory.appraisal.vehiclesearchapp.services.EUserRegistrationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/userReg")
@Api(value = "UserRegistrationController" , description = "Operations in User Registration")
public class UserRegistrationController {
    @Autowired
    private EUserRegistrationServiceImpl eUserRegistrationService;
    @ApiOperation(value = "Add users in database")

    @PostMapping("/createUser")
    public ResponseEntity<UserRegistration> postUserRegistration(@RequestBody @Valid UserRegistration userRegistration){
        return new ResponseEntity<>(eUserRegistrationService.createUser(userRegistration), HttpStatus.CREATED);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserRegistration>> getAllUsers(){
        return new ResponseEntity<>(eUserRegistrationService.getUsers(),HttpStatus.OK);
    }
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserRegistration> updateUser(@PathVariable Long userId, @RequestBody @Valid UserRegistration userRegistration){
        return new ResponseEntity<>(eUserRegistrationService.updateUser(userId,userRegistration),
                HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        return new ResponseEntity<>(eUserRegistrationService.removeUserRegistration(userId),
                HttpStatus.OK
        );
    }

}
