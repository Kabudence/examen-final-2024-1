package com.acme.examenfinal20241.personnel.interfaces.rest.resources;

public record CreateExaminerCommandResource(String firstName,
                                            String lastName,
                                            String nationalProviderIdentifier) {
}
