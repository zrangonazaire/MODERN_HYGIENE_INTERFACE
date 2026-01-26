import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';

import { environment } from '../../../environments/environment';
import { ApiResponse } from '../models/api-response';

export interface RoleFunctionality {
  id: number;
  roleId: number;
  functionalityId: number;
  createdAt?: string;
  updatedAt?: string;
}

@Injectable({ providedIn: 'root' })
export class RoleFunctionalityService {
  private readonly baseUrl = environment.apiBaseUrl;

  constructor(private readonly http: HttpClient) {}

  getRoleFunctionalities(): Observable<RoleFunctionality[]> {
    return this.http
      .get<ApiResponse<{ roleFunctionalities: RoleFunctionality[] }>>(`${this.baseUrl}/role-functionality`)
      .pipe(map((response) => response.data.roleFunctionalities));
  }

  getRoleFunctionalityById(id: number): Observable<RoleFunctionality> {
    return this.http
      .get<ApiResponse<{ roleFunctionality: RoleFunctionality }>>(`${this.baseUrl}/role-functionality/${id}`)
      .pipe(map((response) => response.data.roleFunctionality));
  }

  createRoleFunctionality(roleFunctionality: Omit<RoleFunctionality, 'id'>): Observable<RoleFunctionality> {
    return this.http
      .post<ApiResponse<{ roleFunctionality: RoleFunctionality }>>(`${this.baseUrl}/role-functionality/save`, roleFunctionality)
      .pipe(map((response) => response.data.roleFunctionality));
  }

  updateRoleFunctionality(id: number, roleFunctionality: Partial<RoleFunctionality>): Observable<RoleFunctionality> {
    return this.http
      .put<ApiResponse<{ roleFunctionality: RoleFunctionality }>>(`${this.baseUrl}/role-functionality/${id}`, roleFunctionality)
      .pipe(map((response) => response.data.roleFunctionality));
  }

  deleteRoleFunctionality(id: number): Observable<void> {
    return this.http
      .delete<ApiResponse<{ roleFunctionality: RoleFunctionality }>>(`${this.baseUrl}/role-functionality/${id}`)
      .pipe(map(() => {}));
  }
}