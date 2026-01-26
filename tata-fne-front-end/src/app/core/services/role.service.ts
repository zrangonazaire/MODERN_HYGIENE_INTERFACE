import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';

import { environment } from '../../../environments/environment';
import { ApiResponse } from '../models/api-response';
import { Role } from '../models/role';

@Injectable({ providedIn: 'root' })
export class RoleService {
  private readonly baseUrl = environment.apiBaseUrl;

  constructor(private readonly http: HttpClient) {}

  getRoles(): Observable<Role[]> {
    return this.http
      .get<ApiResponse<{ roles: Role[] }>>(`${this.baseUrl}/roles`)
      .pipe(map((response) => response.data.roles));
  }

  getRoleById(id: number): Observable<Role> {
    return this.http
      .get<ApiResponse<{ role: Role }>>(`${this.baseUrl}/roles/${id}`)
      .pipe(map((response) => response.data.role));
  }

  createRole(role: Omit<Role, 'id'>): Observable<Role> {
    return this.http
      .post<ApiResponse<{ role: Role }>>(`${this.baseUrl}/roles/save`, role)
      .pipe(map((response) => response.data.role));
  }

  updateRole(id: number, role: Partial<Role>): Observable<Role> {
    return this.http
      .put<ApiResponse<{ role: Role }>>(`${this.baseUrl}/roles/${id}`, role)
      .pipe(map((response) => response.data.role));
  }

  deleteRole(id: number): Observable<void> {
    return this.http
      .delete<ApiResponse<{ role: Role }>>(`${this.baseUrl}/roles/${id}`)
      .pipe(map(() => {}));
  }
}
