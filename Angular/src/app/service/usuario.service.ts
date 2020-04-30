import { Usuario } from './../model/usuario';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private baseUrl = `${window.location.protocol}//${window.location.hostname}:8080/api/`;

  constructor(private http:HttpClient) { }

  getUsuarioList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+'usuarios-list');
  }

  addUsuario(usuario:Usuario):Observable<any>{
    return this.http.post(`${this.baseUrl}usuarios-add`,usuario);
  }

  usuarioLogIn(username:String, password:String):Observable<Usuario>
  {
    return this.http.post<Usuario>(`${this.baseUrl}usuarios-login`,[username,password]);
  }
}
