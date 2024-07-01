package com.acme.examenfinal20241.personnel.domain.service;

import com.acme.examenfinal20241.personnel.domain.model.aggregates.Examiner;
import com.acme.examenfinal20241.personnel.domain.model.commands.CreateExaminerCommand;

import java.util.Optional;

public interface ExaminerCommandService {

    Optional<Examiner> handle(CreateExaminerCommand command);
}
