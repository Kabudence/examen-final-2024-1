package com.acme.u202119880.assessment.interfaces.rest.transform;

import com.acme.u202119880.assessment.domain.model.commands.CreateMentalStateExamCommand;
import com.acme.u202119880.assessment.interfaces.rest.resources.CreateMentalStateExamCommandResource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CreateMentalStateExamCommandFromResource {
    public static CreateMentalStateExamCommand toCommandFromResource(CreateMentalStateExamCommandResource resource) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        /**
         * This try-catch block is used to parse the date from the resource.examDate() string.
         * If the date is not in the correct format, a ParseException is thrown.
         */
        try {
            date = formatter.parse(resource.examDate());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use YYYY-MM-DD.", e);
        }

        UUID examinerNationalProviderId;
        /**
         * This try-catch block is used to parse the UUID from the resource.examinerNationalProviderId() string.
         * If the UUID is not in the correct format, an IllegalArgumentException is thrown.
         */
        try {
            examinerNationalProviderId = UUID.fromString(resource.examinerNationalProviderId());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID format for examinerNationalProviderId.", e);
        }

        return new CreateMentalStateExamCommand(
                date,
                resource.orientationScore(),
                resource.registrationScore(),
                resource.attentionAndCalculationScore(),
                examinerNationalProviderId,
                resource.patientId(),
                resource.realScore(),
                resource.languageScore()
        );
    }
}
