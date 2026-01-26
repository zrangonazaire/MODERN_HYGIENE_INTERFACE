import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';

import { environment } from '../../../environments/environment';
import { ApiResponse } from '../models/api-response';

export interface Etablissement {
  id: number;
  codeEtablissement: string;
  nom: string;
  typeEtablissement: string;
  adresse: string;
  ville: string;
  telephone: string;
  email: string;
  responsable: string;
  dateOuverture: string;
  activitePrincipale: string;
  idSociete: number;
  createdAt?: string;
  updatedAt?: string;
}

@Injectable({ providedIn: 'root' })
export class EtablissementService {
  private readonly baseUrl = environment.apiBaseUrl;

  constructor(private readonly http: HttpClient) {}

  getEtablissements(): Observable<Etablissement[]> {
    return this.http
      .get<ApiResponse<{ etablissements: Etablissement[] }>>(`${this.baseUrl}/etablissement`)
      .pipe(map((response) => response.data.etablissements));
  }

  getEtablissementById(id: number): Observable<Etablissement> {
    return this.http
      .get<ApiResponse<{ etablissement: Etablissement }>>(`${this.baseUrl}/etablissement/${id}`)
      .pipe(map((response) => response.data.etablissement));
  }

  createEtablissement(etablissement: Omit<Etablissement, 'id'>): Observable<Etablissement> {
    return this.http
      .post<ApiResponse<{ etablissement: Etablissement }>>(`${this.baseUrl}/etablissements/create`, etablissement)
      .pipe(map((response) => response.data.etablissement));
  }

  updateEtablissement(id: number, etablissement: Partial<Etablissement>): Observable<Etablissement> {
    return this.http
      .put<ApiResponse<{ etablissement: Etablissement }>>(`${this.baseUrl}/etablissement/${id}`, etablissement)
      .pipe(map((response) => response.data.etablissement));
  }

  deleteEtablissement(id: number): Observable<void> {
    return this.http
      .delete<ApiResponse<{ etablissement: Etablissement }>>(`${this.baseUrl}/etablissement/${id}`)
      .pipe(map(() => {}));
  }
}