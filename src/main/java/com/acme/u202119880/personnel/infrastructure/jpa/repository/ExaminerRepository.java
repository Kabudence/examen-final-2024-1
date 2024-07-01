package com.acme.examenfinal20241.personnel.infrastructure.jpa.repository;

import com.acme.examenfinal20241.personnel.domain.model.aggregates.Examiner;
import com.acme.examenfinal20241.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExaminerRepository extends JpaRepository<Examiner, Long> {

    boolean existsByNationalProviderIdentifier(@NotNull(message = "National Provider Identifier is required") NationalProviderIdentifier nationalProviderIdentifier);
    Optional<Examiner>findByNationalProviderIdentifier(@NotNull(message = "National Provider Identifier is required") NationalProviderIdentifier nationalProviderIdentifier);

}
