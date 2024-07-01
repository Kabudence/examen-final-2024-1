package com.acme.examenfinal20241.mentalstateexaman.interfaces.rest.resources;

import java.util.Date;
import java.util.UUID;

public record MentalStateExamResource(Long id,
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
