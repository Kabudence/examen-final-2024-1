package com.acme.examenfinal20241.mentalstateexaman.domain.exceptions;

public class RegistrationScoreMustBeBetween extends RuntimeException{
    public  RegistrationScoreMustBeBetween(Integer registrationScore) {
        super("Registration score must be between 0 and 3, but was: " + registrationScore);
    }
}
