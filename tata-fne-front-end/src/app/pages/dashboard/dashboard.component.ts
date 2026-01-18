import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { AuthenticationService } from '../../core/services/authentication.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {
  protected readonly userFullName = signal('Compte');

  constructor(private readonly auth: AuthenticationService, private readonly router: Router) {
    this.userFullName.set(this.auth.getCurrentFullName() ?? 'Compte');
  }

  protected logout(): void {
    this.auth.logout();
    this.router.navigate(['/login']);
  }
}
