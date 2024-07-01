package com.acme.examenfinal20241.mentalstateexaman.interfaces.rest.resources;

import java.util.Date;
import java.util.UUID;

public record CreateMentalStateExamCommandResource(String examDate,
                                                   Integer orientationScore,
                                                   Integer registrationScore,
                                                   Integer attentionAndCalculationScore,
                                                   String examinerNationalProviderId,
                                                   Long patientId,
                                                   Integer realScore,
                                                   Integer languageScore) {
}
