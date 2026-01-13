package com.bzdata.TataFneBackend.FactureFne;

import java.util.List;

public interface FactureFneService {
InvoiceCertificationResponseDTO certifyInvoice(InvoiceDTO invoiceDTO)throws Exception   ;
List<InvoiceCertificationResponseDTO>certifyEnMasseInvoice(List<InvoiceDTO> invoiceDTOs)throws Exception    ;
InvoiceDTO saveInvoiceDTO(InvoiceDTO invoiceDTO)throws Exception ;
}
