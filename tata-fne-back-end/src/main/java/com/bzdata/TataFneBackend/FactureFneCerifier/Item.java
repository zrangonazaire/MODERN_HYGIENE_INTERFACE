package com.bzdata.TataFneBackend.FactureFneCerifier;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.Data;

@Data
public class Item {
 private String id;
        private Integer quantity;
        private String reference;
        private String description;

        private Long amount;
        private Integer discount;

        private String measurementUnit;

        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;

        private List<ItemTax> taxes;

        private List<ItemCustomTax> customTaxes;

        private String invoiceId;
        private String parentId;
}
