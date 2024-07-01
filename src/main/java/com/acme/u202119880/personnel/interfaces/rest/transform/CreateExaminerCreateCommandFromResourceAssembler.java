package com.acme.u202119880.personnel.interfaces.rest.transform;

import com.acme.u202119880.personnel.domain.model.commands.CreateExaminerCommand;
import com.acme.u202119880.personnel.interfaces.rest.resources.CreateExaminerCommandResource;

import java.util.UUID;

public class CreateExaminerCreateCommandFromResource {

    public static CreateExaminerCommand toCommandFromResource(CreateExaminerCommandResource resource) {
        UUID nationalProviderIdentifier;
        /**
         * The UUID.fromString method throws an IllegalArgumentException if the string does not conform to the UUID format.
         * This is a good practice to validate the UUID format before creating the UUID object.
         */
        try {
            nationalProviderIdentifier = UUID.fromString(resource.nationalProviderIdentifier());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID format for nationalProviderIdentifier.", e);
        }

        return new CreateExaminerCommand(
                resource.firstName(),
                resource.lastName(),
                nationalProviderIdentifier
        );
    }
}
