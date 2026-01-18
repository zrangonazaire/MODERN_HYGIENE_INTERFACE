import { Component, signal } from '@angular/core';
import { NavigationEnd, Router, RouterOutlet } from '@angular/router';
import { filter } from 'rxjs';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('tata-fne-front-end');
  protected readonly isHeaderless = signal(false);

  constructor(private readonly router: Router) {
    this.isHeaderless.set(this.shouldHideHeader(this.router.url));

    this.router.events
      .pipe(filter((event): event is NavigationEnd => event instanceof NavigationEnd))
      .subscribe((event) => {
        this.isHeaderless.set(this.shouldHideHeader(event.urlAfterRedirects));
      });
  }

  private shouldHideHeader(url: string): boolean {
    return (
      url.startsWith('/login') ||
      url.startsWith('/dashboard') ||
      url.startsWith('/factures-certifiees') ||
      url.startsWith('/factures-non-certifiees')
    );
  }
}
