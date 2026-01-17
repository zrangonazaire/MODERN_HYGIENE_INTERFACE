package com.bzdata.TataFneBackend.FactureFneCerifier;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class ItemCustomTax {
 private String id;
        private String invoiceItemId;
        private Integer amount;
        private String name;

        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
}
