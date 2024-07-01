package com.acme.examenfinal20241.mentalstateexaman.domain.exceptions;

public class RecallScoreMustBeBetween extends RuntimeException{
    public RecallScoreMustBeBetween(Integer recallScore) {
        super("Recall score must be between 0 and 3, but was: " + recallScore);
    }
}
