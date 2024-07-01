package com.acme.u202119880.personnel.interfaces.rest.transform;

import com.acme.u202119880.personnel.domain.model.aggregates.Examiner;
import com.acme.u202119880.personnel.interfaces.rest.resources.ExaminerResource;

public class CreateExaminerResourceFromEntity {
    public static ExaminerResource roResourceFromEntity(Examiner examiner) {
        return new ExaminerResource(examiner.getId(),
                examiner.getFirstName(),
                examiner.getLastName(),
                examiner.getNationalProviderIdentifier()
        );
    }
}
