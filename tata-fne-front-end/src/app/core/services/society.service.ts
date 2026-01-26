import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';

import { environment } from '../../../environments/environment';
import { ApiResponse } from '../models/api-response';

export interface Society {
  id: number;
  raisonSociale: string;
  sigle: string;
  formeJuridique: string;
  objetSocial: string;
  numeroRccm: string;
  numeroIfu: string;
  capitalSocial: number;
  siegeSocial: string;
  pays: string;
  ville: string;
  adresse: string;
  telephone: string;
  email: string;
  siteWeb: string;
  dirigeantPrincipal: string;
  exerciceComptableDebut: string;
  exerciceComptableFin: string;
  createdAt?: string;
  updatedAt?: string;
}

@Injectable({ providedIn: 'root' })
export class SocietyService {
  private readonly baseUrl = environment.apiBaseUrl;

  constructor(private readonly http: HttpClient) {}

  getSocieties(): Observable<Society[]> {
    return this.http
      .get<ApiResponse<{ societies: Society[] }>>(`${this.baseUrl}/societes`)
      .pipe(map((response) => response.data.societies));
  }

  getSocietiesPaginated(page: number = 0, size: number = 10): Observable<{
    societies: Society[];
    currentPage: number;
    totalItems: number;
    totalPages: number;
  }> {
    return this.http
      .get<ApiResponse<{
        societies: Society[];
        currentPage: number;
        totalItems: number;
        totalPages: number;
      }>>(`${this.baseUrl}/societes/paginated?page=${page}&size=${size}`)
      .pipe(map((response) => ({
        societies: response.data.societies,
        currentPage: response.data.currentPage,
        totalItems: response.data.totalItems,
        totalPages: response.data.totalPages
      })));
  }

  getSocietyById(id: number): Observable<Society> {
    return this.http
      .get<ApiResponse<{ societe: Society }>>(`${this.baseUrl}/societes/${id}`)
      .pipe(map((response) => response.data.societe));
  }

  createSociety(society: Omit<Society, 'id'>): Observable<Society> {
    return this.http
      .post<ApiResponse<{ societe: Society }>>(`${this.baseUrl}/societe/save`, society)
      .pipe(map((response) => response.data.societe));
  }

  updateSociety(id: number, society: Partial<Society>): Observable<Society> {
    return this.http
      .put<ApiResponse<{ societe: Society }>>(`${this.baseUrl}/societes/${id}`, society)
      .pipe(map((response) => response.data.societe));
  }

  deleteSociety(id: number): Observable<void> {
    return this.http
      .delete<ApiResponse<{ societe: Society }>>(`${this.baseUrl}/societes/${id}`)
      .pipe(map(() => {}));
  }
}