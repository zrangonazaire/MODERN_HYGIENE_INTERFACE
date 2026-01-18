export interface CertifiedInvoice {
  id: string;
  numeroFactureInterne: string;
  utilisateurCreateur: string;
  reference: string;
  date: string;
  totalTTC: number;
  totalHorsTaxes: number;
  totalTaxes: number;
  token: string;
}
