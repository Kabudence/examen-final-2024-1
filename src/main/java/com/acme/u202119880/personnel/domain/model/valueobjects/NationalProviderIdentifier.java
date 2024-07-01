package com.acme.examenfinal20241.personnel.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record NationalProviderIdentifier(UUID nationalProviderIdentifier) {
    public NationalProviderIdentifier {
        if (nationalProviderIdentifier == null) {
            throw new IllegalArgumentException("National provider identifier cannot be null");
        }
    }


}
