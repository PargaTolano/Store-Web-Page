import { Observable } from 'rxjs';
import { Producto } from './../model/producto';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private baseUrl = `${window.location.protocol}//${window.location.hostname}:8080/api/productos-`;

  constructor(private http:HttpClient) { }


  save(producto:Producto)
  {
    return this.http.post<Producto>(`${this.baseUrl}save`, producto);
  }

  update(producto:Producto)
  {
    return this.http.post<Producto>(`${this.baseUrl}update`, producto);
  }

  delete(producto:Producto)
  {
    return this.http.post<Producto>(`${this.baseUrl}delete`, producto);
  }

  getById(id:number):Observable<Producto>
  {
    return this.http.get<Producto>(`${this.baseUrl}id/${id}`);
  }

  getAll():Observable<any>
  {
    return this.http.get(`${this.baseUrl}list`);
  }

}
