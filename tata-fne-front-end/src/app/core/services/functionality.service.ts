import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';

import { environment } from '../../../environments/environment';
import { ApiResponse } from '../models/api-response';

export interface Functionality {
  id: number;
  nom: string;
  description: string;
  code: string;
  createdAt?: string;
  updatedAt?: string;
}

@Injectable({ providedIn: 'root' })
export class FunctionalityService {
  private readonly baseUrl = environment.apiBaseUrl;

  constructor(private readonly http: HttpClient) {}

  getFunctionalities(): Observable<Functionality[]> {
    return this.http
      .get<ApiResponse<{ functionalities: Functionality[] }>>(`${this.baseUrl}/functionality`)
      .pipe(map((response) => response.data.functionalities));
  }

  getFunctionalityById(id: number): Observable<Functionality> {
    return this.http
      .get<ApiResponse<{ functionality: Functionality }>>(`${this.baseUrl}/functionality/${id}`)
      .pipe(map((response) => response.data.functionality));
  }

  createFunctionality(functionality: Omit<Functionality, 'id'>): Observable<Functionality> {
    return this.http
      .post<ApiResponse<{ functionality: Functionality }>>(`${this.baseUrl}/functionality/save`, functionality)
      .pipe(map((response) => response.data.functionality));
  }

  updateFunctionality(id: number, functionality: Partial<Functionality>): Observable<Functionality> {
    return this.http
      .put<ApiResponse<{ functionality: Functionality }>>(`${this.baseUrl}/functionality/${id}`, functionality)
      .pipe(map((response) => response.data.functionality));
  }

  deleteFunctionality(id: number): Observable<void> {
    return this.http
      .delete<ApiResponse<{ functionality: Functionality }>>(`${this.baseUrl}/functionality/${id}`)
      .pipe(map(() => {}));
  }
}