package com.acme.examenfinal20241.mentalstateexaman.domain.exceptions;

import java.util.UUID;

public class ExaminerWithSameNationalProviderIdNotExists extends RuntimeException{
    public ExaminerWithSameNationalProviderIdNotExists(UUID nationalProviderIdentifier) {
        super("Examiner with national provider identifier: " + nationalProviderIdentifier + " does not exist");
    }
}
