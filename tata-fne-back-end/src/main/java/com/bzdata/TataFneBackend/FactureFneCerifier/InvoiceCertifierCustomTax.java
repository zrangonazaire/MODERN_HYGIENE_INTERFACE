package com.bzdata.TataFneBackend.FactureFneCerifier;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class InvoiceCertifierCustomTax {
 private String id;
        private String invoiceId;
        private Integer amount;
        private String name;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
}
