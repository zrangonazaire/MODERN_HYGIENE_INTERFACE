import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '../../../environments/environment';
import { InvoiceCertificationResponse } from '../models/invoice-certification-response';
import { NonCertifiedInvoice } from '../models/non-certified-invoice';
import { CertifiedInvoice } from '../models/certified-invoice';
import { InvoiceSignRequest } from '../models/invoice-sign-request';

@Injectable({ providedIn: 'root' })
export class FneInvoiceService {
  private readonly baseUrl = environment.apiBaseUrl;

  constructor(private readonly http: HttpClient) {}

  getInvoices(): Observable<NonCertifiedInvoice[]> {
    return this.http.get<NonCertifiedInvoice[]>(`${this.baseUrl}/fne/invoices`);
  }

  certifyMass(invoiceIds: number[]): Observable<InvoiceCertificationResponse[]> {
    return this.http.post<InvoiceCertificationResponse[]>(`${this.baseUrl}/fne/invoices/certify-mass`, {
      invoiceIds
    });
  }

  getCertifiedInvoices(): Observable<CertifiedInvoice[]> {
    return this.http.get<CertifiedInvoice[]>(`${this.baseUrl}/new-invoices/all-certified-invoices`);
  }

  certifyFinalFacture(numFacture: string, utilisateur: string, payload: InvoiceSignRequest): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/new-invoices/certify-final-facture/${numFacture}/${utilisateur}`, payload);
  }
}
