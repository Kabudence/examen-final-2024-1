package com.acme.examenfinal20241.mentalstateexaman.domain.model.commands;

import com.acme.examenfinal20241.mentalstateexaman.domain.model.valueobjects.ExaminerNationalProviderId;

import java.util.Date;
import java.util.UUID;

public record CreateMentalStateExamCommand(
        Date examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        UUID examinerNationalProviderId,
        Long patientId,
        Integer realScore,
        Integer languageScore
) {
}
