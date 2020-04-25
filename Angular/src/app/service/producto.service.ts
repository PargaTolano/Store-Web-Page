import { Observable } from 'rxjs';
import { Producto } from './../model/producto';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private baseUrl = "http://localhost:8080/api/productos-";

  constructor(private http:HttpClient) { }

  getById(id:number):Observable<Producto>
  {
    return this.http.get<Producto>(`${this.baseUrl}id/${id}`);
  }

  getAll():Observable<any>
  {
    return this.http.get(`${this.baseUrl}list`);
  }

}
