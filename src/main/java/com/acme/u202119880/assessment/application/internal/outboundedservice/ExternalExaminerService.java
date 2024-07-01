package com.acme.examenfinal20241.mentalstateexaman.application.internal.outboundedservice;

import com.acme.examenfinal20241.personnel.interfaces.acl.ExaminerContextFacade;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExternalExaminerService {

    private final ExaminerContextFacade examinerContextFacade;

    public ExternalExaminerService(ExaminerContextFacade examinerContextFacade) {
        this.examinerContextFacade = examinerContextFacade;
    }

    public boolean existExaminerByNationalProviderId(UUID nationalProviderIdentifier) {
        return examinerContextFacade.existExaminerByNationalProviderId(nationalProviderIdentifier);
    }
}
