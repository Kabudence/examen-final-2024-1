package com.acme.examenfinal20241.mentalstateexaman.domain.exceptions;

public class AtentionAndCalculationScoreMustBeBetween extends RuntimeException{
    public AtentionAndCalculationScoreMustBeBetween(Integer atentionAndCalculationScore) {
        super("Atention and calculation score must be between 0 and 5, but was: " + atentionAndCalculationScore);
    }
}
