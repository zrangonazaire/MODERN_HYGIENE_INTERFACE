package com.bzdata.TataFneBackend.FactureFne;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InvoiceCertificationResponseDTO(
        String ncc,
        String reference,
        String token,
        boolean warning,

        @JsonProperty("balance_sticker")
        int balanceSticker,

        CertifiedInvoiceDTO invoice
) {}
