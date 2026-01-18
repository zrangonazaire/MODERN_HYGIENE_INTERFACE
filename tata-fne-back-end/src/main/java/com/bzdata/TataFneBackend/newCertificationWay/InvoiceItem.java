package com.bzdata.TataFneBackend.newCertificationWay;


import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class InvoiceItem {

    private List<String> taxes;     // ["TVAC"]
    private String description;

    private Integer quantity;
    private Integer amount;
}
