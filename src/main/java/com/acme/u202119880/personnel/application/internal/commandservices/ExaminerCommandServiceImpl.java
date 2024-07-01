package com.acme.examenfinal20241.personnel.application.internal.commandservices;

import com.acme.examenfinal20241.personnel.domain.exceptions.ExaminerWithNationalProviderAlreadyExists;
import com.acme.examenfinal20241.personnel.domain.model.aggregates.Examiner;
import com.acme.examenfinal20241.personnel.domain.model.commands.CreateExaminerCommand;
import com.acme.examenfinal20241.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import com.acme.examenfinal20241.personnel.domain.service.ExaminerCommandService;
import com.acme.examenfinal20241.personnel.infrastructure.jpa.repository.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
/**
 * This class implements the ExaminerCommandService interface
 * @see ExaminerCommandService
 *  This class is responsible for handling the creation of a new examiner
 */
@Service
public class ExaminerCommandServiceImpl implements ExaminerCommandService {

    private final ExaminerRepository examinerRepository;
    /**
     * This is the constructor of the class
     * @param examinerRepository
     *  This is the constructor of the class
     */
    public ExaminerCommandServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }
    /**
     * This method creates a new examiner
     * @param command containing examiner details
     *  This method validates the examiner details and creates a new examiner
     * @return Examiner
     */
    @Override
    public Optional<Examiner> handle(CreateExaminerCommand command) {
        var nationalProviderId= new NationalProviderIdentifier(command.nationalProviderIdentifier());

        if (examinerRepository.existsByNationalProviderIdentifier(nationalProviderId))
            throw new ExaminerWithNationalProviderAlreadyExists(command.nationalProviderIdentifier());

        var examiner = new Examiner(command, nationalProviderId);
        examinerRepository.save(examiner);
        return Optional.of(examiner);
    }
}
