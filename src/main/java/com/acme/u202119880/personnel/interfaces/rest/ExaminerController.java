package com.acme.examenfinal20241.personnel.interfaces.rest;

import com.acme.examenfinal20241.personnel.domain.service.ExaminerCommandService;
import com.acme.examenfinal20241.personnel.domain.service.ExaminerQueryService;
import com.acme.examenfinal20241.personnel.interfaces.rest.resources.CreateExaminerCommandResource;
import com.acme.examenfinal20241.personnel.interfaces.rest.resources.ExaminerResource;
import com.acme.examenfinal20241.personnel.interfaces.rest.transform.CreateExaminerCreateCommandFromResource;
import com.acme.examenfinal20241.personnel.interfaces.rest.transform.CreateExaminerResourceFromEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * This class is a REST controller that exposes the examiner resource.
 * It includes the following operations:
 * - POST /api/v1/examiner: creates a new examiner
 */
@RestController
@RequestMapping(value = "/api/v1/examiner", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Examiner", description = "Examiner Management Endpoints")
public class ExaminerController {

    private final ExaminerCommandService examinerCommandService;
    private final ExaminerQueryService examinerQueryService;
    /**
     * Constructor
     * @param examinerCommandService its represents the examiner command service
     * @param examinerQueryService its represents the examiner query service
     */
    public ExaminerController(ExaminerCommandService examinerCommandService, ExaminerQueryService examinerQueryService) {
        this.examinerCommandService = examinerCommandService;
        this.examinerQueryService = examinerQueryService;
    }

    /** This method creates a new examiner.
     * It validates the examiner name, email, and checks if an examiner with the same email already exists.
     * @param resource containing examiner details
     * @return the created examiner
     */
        @PostMapping
    public ResponseEntity<ExaminerResource> createExaminer(@RequestBody CreateExaminerCommandResource resource) {
        var createExaminerCommand = CreateExaminerCreateCommandFromResource.toCommandFromResource(resource);
        var examiner = examinerCommandService.handle(createExaminerCommand);
        if (examiner.isEmpty()) return ResponseEntity.badRequest().build();
        var examinerResource = CreateExaminerResourceFromEntity.roResourceFromEntity(examiner.get());
        return new ResponseEntity<>(examinerResource, HttpStatus.CREATED);
    }
}
