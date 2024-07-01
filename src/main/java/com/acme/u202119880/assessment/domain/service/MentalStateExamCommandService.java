package com.acme.examenfinal20241.mentalstateexaman.domain.service;

import com.acme.examenfinal20241.mentalstateexaman.domain.model.aggregates.MentalStateExam;
import com.acme.examenfinal20241.mentalstateexaman.domain.model.commands.CreateMentalStateExamCommand;

import java.util.Optional;

public interface MentalStateExamCommandService {

    Optional<MentalStateExam>handle(CreateMentalStateExamCommand command);
}
