package com.acme.examenfinal20241.mentalstateexaman.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record ExaminerNationalProviderId(UUID examinerNationalProviderId) {
    public ExaminerNationalProviderId {
        if (examinerNationalProviderId == null) {
            throw new IllegalArgumentException("Examiner National Provider Id cannot be null");
        }
    }


}
