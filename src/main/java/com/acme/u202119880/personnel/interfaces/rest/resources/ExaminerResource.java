package com.acme.examenfinal20241.personnel.interfaces.rest.resources;

import java.util.UUID;

public record ExaminerResource(Long id,
                               String firstName,
                               String lastName,
                               UUID nationalProviderIdentifier) {
}
