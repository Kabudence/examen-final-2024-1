package com.acme.examenfinal20241.mentalstateexaman.domain.model.aggregates;

import com.acme.examenfinal20241.mentalstateexaman.domain.model.commands.CreateMentalStateExamCommand;
import com.acme.examenfinal20241.mentalstateexaman.domain.model.valueobjects.ExaminerNationalProviderId;
import com.acme.examenfinal20241.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

/**
 * MentalStateExam entity.
 * Represents the mental state exam.
 */
@Entity
public class MentalStateExam extends AuditableAbstractAggregateRoot<MentalStateExam> {

    @Getter
    @NotNull(message = "Examiner National Date is required")
    private Date examDate;
    @Min(0)
    @Max(10)
    @Getter
    @NotNull(message = "Orientation score is required")
    private Integer orientationScore;
    @Min(0)
    @Max(3)
    @Getter
    @NotNull(message = "Registration score is required")
    private Integer registrationScore;
    @Min(0)
    @Max(5)
    @Getter
    @NotNull(message = "Attention and calculation score is required")
    private Integer attentionAndCalculationScore;

    @Embedded
    @NotNull(message = "Examiner National Provider Id is required")
    private ExaminerNationalProviderId examinerNationalProviderId;

    @Getter
    @NotNull(message = "PatientId is required")
    private Long patientId;
    @Min(0)
    @Max(3)
    @Getter
    @NotNull(message = "Recall score is required")
    private Integer recallScore;
    @Min(0)
    @Max(9)
    @Getter
    @NotNull(message = "Language score is required")
    private Integer languageScore ;

    /**
     * Constructor.
     *default constructor
     */
    public MentalStateExam() {
    }

    /**
     * Constructor.
     * @param command its represent the command
     * @param providerId its represent the provider id
     * Constructor with parameters
     */
    public MentalStateExam(CreateMentalStateExamCommand command, ExaminerNationalProviderId providerId){
        this.examDate = command.examDate();
        this.orientationScore = command.orientationScore();
        this.registrationScore = command.registrationScore();
        this.attentionAndCalculationScore = command.attentionAndCalculationScore();
        this.examinerNationalProviderId = providerId;
        this.patientId = command.patientId();
        this.recallScore = command.realScore();
        this.languageScore = command.languageScore();
    }
        /**
         *  getExaminerNationalProviderId
         *  @return Long
         * */
    public UUID getExaminerNationalProviderId() {
        return examinerNationalProviderId.examinerNationalProviderId();
    }
}
