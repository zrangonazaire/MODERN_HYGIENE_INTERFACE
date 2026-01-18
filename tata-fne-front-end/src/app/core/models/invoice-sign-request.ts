export interface InvoiceItem {
  taxes?: string[];
  description?: string;
  quantity?: number;
  amount?: number;
}

export interface InvoiceSignRequest {
  invoiceType?: string;
  paymentMethod?: string;
  template?: string;
  numeroFacture?: string;
  clientNcc?: string;
  clientCompanyName?: string;
  clientPhone?: string;
  clientEmail?: string;
  pointOfSale?: string;
  establishment?: string;
  commercialMessage?: string;
  items?: InvoiceItem[];
  discount?: number;
}
