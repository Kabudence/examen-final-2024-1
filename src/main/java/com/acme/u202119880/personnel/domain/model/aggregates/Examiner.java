package com.acme.examenfinal20241.personnel.domain.model.aggregates;

import com.acme.examenfinal20241.personnel.domain.model.commands.CreateExaminerCommand;
import com.acme.examenfinal20241.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import com.acme.examenfinal20241.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

/**
 * Examiner.
 * Is represents the person who examines the patient.
 */
@Entity
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {

    @Getter
    @NotNull(message = "First name is required")
    @NotBlank
    private String firstName;

    @Getter
    @NotNull(message = "Last name is required")
    @NotBlank
    private String lastName;
    /**
     * National Provider Identifier.
     * Represents the national provider identifier.
     */
    @Embedded
    @NotNull(message = "National Provider Identifier is required")
    private NationalProviderIdentifier nationalProviderIdentifier;


    /**
     * Constructor.
     * @param command CreateExaminerCommand.
     * @param nationalProviderIdentifier NationalProviderIdentifier.
     */
    public Examiner(CreateExaminerCommand command,NationalProviderIdentifier nationalProviderIdentifier) {
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        this.nationalProviderIdentifier = nationalProviderIdentifier;
    }
    /**
     * Constructor for default.
     */
    public Examiner() {

    }
    /**
     * Get National Provider Identifier.
     * @return UUID.
     */
    public UUID getNationalProviderIdentifier() {
        return nationalProviderIdentifier.nationalProviderIdentifier();
    }



}
