import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Router }            from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Usuario } from 'src/app/model/usuario';
import { UsuarioService } from 'src/app/service/usuario.service';
import { analyzeAndValidateNgModules } from '@angular/compiler';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss']
})
export class LogInComponent implements OnInit {

  constructor(private usuarioService:UsuarioService) { }

  usuario:Usuario = new Usuario();

  usuariotemp:Usuario;

  submitted:boolean = false;

  ngOnInit(): void {
    this.submitted = false;
  }

  loginForm  =              new FormGroup({
    nombre_usuario:         new FormControl(null , [] ),
    contrasena:             new FormControl(null , [] )
  });

  log_in(login){
    this.usuarioService.usuarioLogIn(this.Username.value, this.Contrasena.value)
    .subscribe(data=> {
      this.usuariotemp = data;
      if(this.usuariotemp != undefined){
        console.log(`result : ${this.usuariotemp.nombre} ${this.usuariotemp.apellido}`);
      }
      else{
        console.log('Error nombre de usuario o contraseña erroneo');
      }
    });

  }

  get Username(){
    return this.loginForm.get('nombre_usuario');
  }

  get Contrasena(){
    return this.loginForm.get('contrasena');
  }
  addForm(){
    this.submitted=false;
    this.loginForm.reset();
  }
}
