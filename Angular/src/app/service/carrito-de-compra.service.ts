import { Observable } from 'rxjs';
import { ProductoComprado } from './../model/producto-comprado';
import { CarritoDeCompra } from './../model/carrito-de-compra';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CarritoDeCompraService {

  constructor(private http:HttpClient,
    private baseUrl=`${window.location.protocol}//${window.location.hostname }:8080/api/carrito-`) { }

  removeProductoComprado(carrito:CarritoDeCompra)
  {
    return this.http.post<boolean>(`${this.baseUrl}remove`,carrito)
  }

  updateProductoComprado(carrito:CarritoDeCompra)
  {
    return this.http.post<boolean>(`${this.baseUrl}update`,carrito)
  }

  addProductoComprado(carrito:CarritoDeCompra)
  {
    return this.http.post<boolean>(`${this.baseUrl}add`,carrito)
  }
}