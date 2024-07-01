package com.acme.examenfinal20241.mentalstateexaman.application.internal.commandservices;

import com.acme.examenfinal20241.personnel.domain.exceptions.ExaminerWithNationalProviderAlreadyExists;
import com.acme.examenfinal20241.mentalstateexaman.application.internal.outboundedservice.ExternalExaminerService;
import com.acme.examenfinal20241.mentalstateexaman.domain.exceptions.*;
import com.acme.examenfinal20241.mentalstateexaman.domain.model.aggregates.MentalStateExam;
import com.acme.examenfinal20241.mentalstateexaman.domain.model.commands.CreateMentalStateExamCommand;
import com.acme.examenfinal20241.mentalstateexaman.domain.model.valueobjects.ExaminerNationalProviderId;
import com.acme.examenfinal20241.mentalstateexaman.domain.service.MentalStateExamCommandService;
import com.acme.examenfinal20241.mentalstateexaman.infrastructure.jpa.repository.MentalStateExamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
/**
 * MentalStateExamCommandServiceImpl class is responsible for handling the mental state exam commands
 * This class implements the MentalStateExamCommandService interface
 */
@Service
public class MentalStateExamCommandServiceImpl implements MentalStateExamCommandService {

    private final MentalStateExamRepository mentalStateExamRepository;
    private final ExternalExaminerService externalExaminerService;
        /**
         * Constructor of the class
         * @param mentalStateExamRepository repository of mental state exam
         * @param externalExaminerService service to interact with external examiner
         */
    public MentalStateExamCommandServiceImpl(MentalStateExamRepository mentalStateExamRepository, ExternalExaminerService externalExaminerService) {
        this.mentalStateExamRepository = mentalStateExamRepository;
        this.externalExaminerService = externalExaminerService;
    }
    /**
     * Command handler to create mental state exam
     * @param command containing mental state exam details
     * This method validates the mental state exam details and creates a new mental state exam
     * @return MentalStateExam
     */
    @Override
    public Optional<MentalStateExam> handle(CreateMentalStateExamCommand command) {
        if(!externalExaminerService.existExaminerByNationalProviderId(command.examinerNationalProviderId()))
        throw new ExaminerWithNationalProviderAlreadyExists(command.examinerNationalProviderId());
        var examinerNationalProviderId = new ExaminerNationalProviderId(command.examinerNationalProviderId());
        validationTest(command.orientationScore(), command.registrationScore(), command.attentionAndCalculationScore(), command.realScore(), command.languageScore());
        var mentalStateExam = new MentalStateExam(command,examinerNationalProviderId);
        mentalStateExamRepository.save(mentalStateExam);
        return Optional.of(mentalStateExam);

    }
        /**
         * Method to validate the mental state exam details
         * @param orientationScore score of orientation
         * @param registrationScore score of registration
         * @param attentionAndCalculationScore score of attention and calculation
         * @param recallScore   score of recall
         * @param languageScore score of language
         */
    public void validationTest(Integer orientationScore ,Integer registrationScore ,Integer attentionAndCalculationScore ,Integer recallScore , Integer languageScore){

        if(orientationScore < 0 || orientationScore > 10)
            throw new OrientationScoreMustBeBetween(orientationScore);
        if(registrationScore < 0 || registrationScore > 3)
            throw new RegistrationScoreMustBeBetween(registrationScore);
        if(attentionAndCalculationScore < 0 || attentionAndCalculationScore > 5)
            throw new AtentionAndCalculationScoreMustBeBetween(attentionAndCalculationScore);
        if(recallScore < 0 || recallScore > 3)
            throw new RecallScoreMustBeBetween(recallScore);
        if(languageScore < 0 || languageScore > 9)
            throw new LanguageScoreMustBeBetween(languageScore);
    }
}
