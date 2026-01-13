package com.bzdata.TataFneBackend.FactureFne;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("fne")
@RequiredArgsConstructor
@Tag(name = "Facture FNE", description = "Gestion des factures FNE ")
@Slf4j
@Validated
public class FactureFneController {
    private final FactureFneService factureFneService;

    @PostMapping(value="/certifier-facture",consumes="application/json",produces="application/json")
    public ResponseEntity<InvoiceCertificationResponseDTO> certiferFacture(@Valid @RequestBody InvoiceDTO factureFneDTO) throws Exception {
        log.info("Certifying FNE invoice");
        return new ResponseEntity<>(factureFneService.certifyInvoice(factureFneDTO), HttpStatus.ACCEPTED);
    }

}
