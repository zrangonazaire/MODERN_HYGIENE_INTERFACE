package com.bzdata.TataFneBackend.newCertificationWay;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoiceSignRequest {

    private String invoiceType;        // "sale"
    private String paymentMethod;      // "transfer"
    private String template;           // "B2B"
    private String numeroFacture;
    private String clientNcc;
    private String clientCompanyName;
    private String clientPhone;
    private String clientEmail;

    private String pointOfSale;
    private String establishment;

    private String commercialMessage;

    private List<InvoiceItem> items;

    private Integer discount;          // 20
}
