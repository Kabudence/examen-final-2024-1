package com.acme.examenfinal20241.mentalstateexaman.domain.exceptions;

public class OrientationScoreMustBeBetween extends RuntimeException{
    public OrientationScoreMustBeBetween(Integer orientationScore) {
        super("Orientation score must be between 0 and 10, but was: " + orientationScore);
    }
}
