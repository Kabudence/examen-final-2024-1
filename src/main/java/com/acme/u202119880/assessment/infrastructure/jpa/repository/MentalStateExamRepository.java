package com.acme.examenfinal20241.mentalstateexaman.infrastructure.jpa.repository;

import com.acme.examenfinal20241.mentalstateexaman.domain.model.aggregates.MentalStateExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentalStateExamRepository extends JpaRepository<MentalStateExam, Long>{



}
