package com.acme.examenfinal20241.personnel.application.internal.queryservices;

import com.acme.examenfinal20241.personnel.domain.model.aggregates.Examiner;
import com.acme.examenfinal20241.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import com.acme.examenfinal20241.personnel.domain.service.ExaminerQueryService;
import com.acme.examenfinal20241.personnel.infrastructure.jpa.repository.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
/**
 * This class implements the ExaminerQueryService interface
 * @see ExaminerQueryService
 *  This class is responsible for retrieving an examiner by national provider identifier
 */
@Service
public class ExaminerQueryServiceImpl implements ExaminerQueryService {

    private final ExaminerRepository examinerRepository;
    /**
     * This is the constructor of the class
     * @param examinerRepository
     *  This is the constructor of the class
     */
    public ExaminerQueryServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    /**
     * This method retrieves an examiner by national provider identifier
     * @param nationalProviderIdentifier
     *  This method retrieves an examiner by national provider identifier
     * @return Optional<Examiner>
     */
    @Override
    public Optional<Examiner> getExaminerByNationalProviderId(UUID nationalProviderIdentifier) {
        var nationalProviderId = new NationalProviderIdentifier(nationalProviderIdentifier);
        return examinerRepository.findByNationalProviderIdentifier(nationalProviderId);
    }
}
