package com.bzdata.TataFneBackend.newCertificationWay;

import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/new-invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceCertificationService service;

    @PostMapping("/certify")
    public JsonNode certify(@RequestBody InvoiceSignRequest request) {
        return service.certifyInvoice(request);
    }
    @PostMapping("/certify-final")
    public void certifyFinal(@RequestBody InvoiceSignRequest request) {
        service.saveFromJsonToDataba(service.certifyInvoice(request));
    }
    @PostMapping("/certify-final-facture/{numFacture}/{utilisateur}")
    public void certifyFinalWithNumFacture(@RequestBody InvoiceSignRequest request,@PathVariable("numFacture") String numFacture ,@PathVariable("utilisateur")  String utilisateur) {
        service.saveFromJsonToDatabaWithNumFacture(service.certifyInvoice(request),numFacture,utilisateur);
    }
    @PostMapping(value = "/certify-propre", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvoiceMainResponse>  certifyPropre(@RequestBody InvoiceSignRequest request) {
        return ResponseEntity.ok().body(service.certifyInvoicePropre(request));
    }

    // 2) LISTE toutes les factures: /api/invoices
    @GetMapping
    public ResponseEntity<List<InvoiceFneCertifyDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // 3) LISTE par numeroFacture: /api/invoices/by-numero?numeroFacture=FAC-001
    @GetMapping("/by-numero")
    public ResponseEntity<List<InvoiceFneCertifyDto>> getByNumero(@RequestParam String numeroFacture) {
        return ResponseEntity.ok(service.getByNumeroFacture(numeroFacture));
    }
}
