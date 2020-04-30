import { Producto } from './../model/producto';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Imagen } from '../model/imagen';

@Injectable({
  providedIn: 'root'
})
export class ImagenService {

  private baseUrl = `${window.location.protocol}//${window.location.hostname}:8080/api/imagen-`;

  constructor(private http:HttpClient) { }

  getByAllByProduct(producto:Producto):Observable<any>
  {
    return this.http.post(`${this.baseUrl}producto`, producto);
  }


  imagenUrl(imagen:Imagen):string
  {
    return `${this.baseUrl}mostrar/${imagen.id}`
  }

  imagenUrlUrl(imagen:Imagen):string
  {
    return `${this.baseUrl}mostrar-url/${imagen.id}`
  }

  getAll():Observable<any>
  {
    return this.http.get(`${this.baseUrl}list`);
  }
}
