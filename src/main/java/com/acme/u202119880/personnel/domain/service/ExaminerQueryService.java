package com.acme.examenfinal20241.personnel.domain.service;

import com.acme.examenfinal20241.personnel.domain.model.aggregates.Examiner;

import java.util.Optional;
import java.util.UUID;

public interface ExaminerQueryService {

    Optional<Examiner> getExaminerByNationalProviderId(UUID nationalProviderIdentifier);
}
