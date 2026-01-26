import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';

import { environment } from '../../../environments/environment';
import { ApiResponse } from '../models/api-response';

export interface Attribution {
  id: number;
  userId: number;
  roleId: number;
  societyId: number;
  etablissementId: number;
  startDate: string;
  endDate?: string;
  isActive: boolean;
  createdAt?: string;
  updatedAt?: string;
}

@Injectable({ providedIn: 'root' })
export class AttributionService {
  private readonly baseUrl = environment.apiBaseUrl;

  constructor(private readonly http: HttpClient) {}

  getAttributions(): Observable<Attribution[]> {
    return this.http
      .get<ApiResponse<{ attributions: Attribution[] }>>(`${this.baseUrl}/attribution`)
      .pipe(map((response) => response.data.attributions));
  }

  getAttributionById(id: number): Observable<Attribution> {
    return this.http
      .get<ApiResponse<{ attribution: Attribution }>>(`${this.baseUrl}/attribution/${id}`)
      .pipe(map((response) => response.data.attribution));
  }

  createAttribution(attribution: Omit<Attribution, 'id'>): Observable<Attribution> {
    return this.http
      .post<ApiResponse<{ attribution: Attribution }>>(`${this.baseUrl}/attribution/save`, attribution)
      .pipe(map((response) => response.data.attribution));
  }

  updateAttribution(id: number, attribution: Partial<Attribution>): Observable<Attribution> {
    return this.http
      .put<ApiResponse<{ attribution: Attribution }>>(`${this.baseUrl}/attribution/${id}`, attribution)
      .pipe(map((response) => response.data.attribution));
  }

  deleteAttribution(id: number): Observable<void> {
    return this.http
      .delete<ApiResponse<{ attribution: Attribution }>>(`${this.baseUrl}/attribution/${id}`)
      .pipe(map(() => {}));
  }
}