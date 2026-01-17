package com.bzdata.TataFneBackend.FactureFneCerifier;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class ItemTax {
private String invoiceItemId;
        private String vatRateId;
        private Integer amount;
        private String name;
        private String shortName;

        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
}
