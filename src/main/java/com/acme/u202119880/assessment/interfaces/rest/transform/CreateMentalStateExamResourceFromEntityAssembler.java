package com.acme.u202119880.assessment.interfaces.rest.transform;

import com.acme.u202119880.assessment.domain.model.aggregates.MentalStateExam;
import com.acme.u202119880.assessment.interfaces.rest.resources.MentalStateExamResource;

public class CreateMentalStateExamResourceFromEntity {
    public static MentalStateExamResource toResourceFromEntity(MentalStateExam exam) {
        return new MentalStateExamResource(exam.getId(),
                                           exam.getExamDate(),
                                           exam.getOrientationScore(),
                                           exam.getRegistrationScore(),
                                           exam.getAttentionAndCalculationScore(),
                                           exam.getExaminerNationalProviderId(),
                                           exam.getPatientId(),
                                           exam.getRecallScore(),
                                           exam.getLanguageScore());
    }
}
