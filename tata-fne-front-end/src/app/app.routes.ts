import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { FacturesNonCertifieesComponent } from './pages/factures-non-certifiees/factures-non-certifiees.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { CertifiedInvoicesComponent } from './pages/certified-invoices/certified-invoices.component';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'login'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'dashboard',
    component: DashboardComponent
  },
  {
    path: 'factures-certifiees',
    component: CertifiedInvoicesComponent
  },
  {
    path: 'factures-non-certifiees',
    component: FacturesNonCertifieesComponent
  },
  {
    path: '**',
    redirectTo: 'login'
  }
];
