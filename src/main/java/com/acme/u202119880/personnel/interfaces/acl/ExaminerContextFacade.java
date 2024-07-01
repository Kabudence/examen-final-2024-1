package com.acme.examenfinal20241.personnel.interfaces.acl;

import com.acme.examenfinal20241.personnel.domain.model.queries.GetExaminerByNationalProviderId;
import com.acme.examenfinal20241.personnel.domain.service.ExaminerCommandService;
import com.acme.examenfinal20241.personnel.domain.service.ExaminerQueryService;
import org.springframework.stereotype.Service;

import java.util.UUID;
/**
 * This class implements the ExaminerContextFacade interface
 * @see ExaminerContextFacade
 *  This class is responsible for checking if an examiner exists by national provider identifier
 */
@Service
public class ExaminerContextFacade {
    private final ExaminerCommandService examinerCommandService;
    private final ExaminerQueryService examinerQueryService;
    /**
     * This is the constructor of the class
     * @param examinerCommandService its represents the examiner command service
     * @param examinerQueryService its represents the examiner query service
     *  This is the constructor of the class
     */
    public ExaminerContextFacade(ExaminerCommandService examinerCommandService, ExaminerQueryService examinerQueryService) {
        this.examinerCommandService = examinerCommandService;
        this.examinerQueryService = examinerQueryService;
    }
    /**
     * This method checks if an examiner exists by national provider identifier
     * @param nationalProviderIdentifier
     *  This method checks if an examiner exists by national provider identifier
     * @return boolean
     */
    public boolean existExaminerByNationalProviderId(UUID nationalProviderIdentifier) {
    var getExaminerByNationalProviderId = new GetExaminerByNationalProviderId(nationalProviderIdentifier);
    var examiner= examinerQueryService.getExaminerByNationalProviderId(getExaminerByNationalProviderId.nationalProviderIdentifier());
        return examiner.isPresent();
    }
}
