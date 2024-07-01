package com.acme.examenfinal20241.personnel.domain.exceptions;

import java.util.UUID;

public class ExaminerWithNationalProviderAlreadyExists extends RuntimeException{
    public ExaminerWithNationalProviderAlreadyExists(UUID nationalProviderIdentifier) {
        super("Examiner with national provider identifier: " + nationalProviderIdentifier + " already exists");
    }
}
