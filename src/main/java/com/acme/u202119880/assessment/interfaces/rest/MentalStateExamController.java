package com.acme.examenfinal20241.mentalstateexaman.interfaces.rest;

import com.acme.examenfinal20241.mentalstateexaman.domain.service.MentalStateExamCommandService;
import com.acme.examenfinal20241.mentalstateexaman.interfaces.rest.resources.CreateMentalStateExamCommandResource;
import com.acme.examenfinal20241.mentalstateexaman.interfaces.rest.resources.MentalStateExamResource;
import com.acme.examenfinal20241.mentalstateexaman.interfaces.rest.transform.CreateMentalStateExamCommandFromResource;
import com.acme.examenfinal20241.mentalstateexaman.interfaces.rest.transform.CreateMentalStateExamResourceFromEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * This class is a REST controller that exposes the mental state exam resource.
 * It includes the following operations:
 * - POST /api/v1/mental-state-exam: creates a new mental state exam
 */
@RestController
@RequestMapping(value = "/api/v1/mental-state-exam", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mental State Exam", description = "Mental State Exam Management Endpoints")
public class MentalStateExamController {

    private final MentalStateExamCommandService mentalStateExamCommandService;
    /**
     * Constructor
     * @param mentalStateExamCommandService its represents the mental state exam command service
     */
    public MentalStateExamController(MentalStateExamCommandService mentalStateExamCommandService) {
        this.mentalStateExamCommandService = mentalStateExamCommandService;
    }
    /**
     * This method creates a new mental state exam.
     * It validates the mental state exam details.
     * @param resource containing mental state exam details
     * @return the created mental state exam
     */
    @PostMapping
    public ResponseEntity<MentalStateExamResource>createMentalStateExam(@RequestBody CreateMentalStateExamCommandResource resource){
        var createMentalStateExamCommand = CreateMentalStateExamCommandFromResource.toCommandFromResource(resource);
        var mentalStateExam = mentalStateExamCommandService.handle(createMentalStateExamCommand);
        if(mentalStateExam.isEmpty()) return ResponseEntity.badRequest().build();
        var mentalStateExamResource = CreateMentalStateExamResourceFromEntity.toResourceFromEntity(mentalStateExam.get());
        return new ResponseEntity<>(mentalStateExamResource, HttpStatus.CREATED);
    }
}
