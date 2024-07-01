package com.acme.examenfinal20241.mentalstateexaman.domain.exceptions;

public class LanguageScoreMustBeBetween extends RuntimeException{
    public LanguageScoreMustBeBetween(Integer lenguagueScore) {
        super("Language score must be between 0 and 3, but was: " + lenguagueScore);
    }
}
