package com.acme.examenfinal20241.personnel.domain.model.commands;

import java.util.UUID;

public record CreateExaminerCommand(String firstName,
                                    String lastName,
                                    UUID nationalProviderIdentifier) {
}
