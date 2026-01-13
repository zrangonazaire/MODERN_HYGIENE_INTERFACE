package com.bzdata.TataFneBackend.FactureFne;

import java.math.BigDecimal;
import java.time.Instant;

public record CertifiedInvoiceItemDTO(
        String id,

        BigDecimal quantity,
        String reference,
        String description,

        BigDecimal amount,
        BigDecimal discount,

        String measurementUnit,

        Instant createdAt,
        Instant updatedAt
) {}
