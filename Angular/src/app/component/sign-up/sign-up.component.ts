import { Usuario } from './../../model/usuario';
import { UsuarioService } from './../../service/usuario.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  constructor(private usuarioService:UsuarioService) { }

  usuario:Usuario = new Usuario();

  submitted:boolean = false;

  ngOnInit(): void {
    this.submitted = false;
  }

  saveForm  =       new FormGroup({
    usuario_nombre:         new FormControl(null , [Validators.required ] ),
    usuario_apellido:       new FormControl(null , [Validators.required ] ),
    usuario_correo:         new FormControl(null , [Validators.required , Validators.email] ),
    usuario_nombre_usuario: new FormControl(null , [Validators.required , Validators.minLength(6), Validators.maxLength(15)] ),
    usuario_contrasena:     new FormControl(null , [Validators.required ] ),
    usuario_telefono:       new FormControl(null , [Validators.required ] ),
    usuario_Direccion:      new FormControl(null , [Validators.required ] ),
    usuario_Avatar:         new FormControl(null , [Validators.required ] )
  });

  SaveUsuario(saveusuario){
    this.usuario=new Usuario();   
    this.usuario.id             = 0;
    this.usuario.nombre         = this.UsuarioNombre           .value;
    this.usuario.apellido       = this.UsuarioApellido         .value;
    this.usuario.correo         = this.UsuarioEmail            .value;
    this.usuario.nombreUsuario = this.UsuarioNombreUsuario    .value;
    this.usuario.contrasena     = this.UsuarioContrasena       .value;
    this.usuario.telefono       = parseInt(this.UsuarioTelefono.value);
    this.usuario.direccion      = this.UsuarioDireccion        .value;
    this.usuario.avatar         = null;//this.UsuarioAvatar          .value;

    this.submitted = true;
    this.save();
  }

  save() {
    this.usuarioService.addUsuario(this.usuario)
      .subscribe(data => console.log(data), error => console.log(error));
    this.usuario = new Usuario();
  }

  get UsuarioNombre(){
    return this.saveForm.get('usuario_nombre');
  }

  get UsuarioApellido(){
    return this.saveForm.get('usuario_apellido');
  }

  get UsuarioEmail(){
    return this.saveForm.get('usuario_correo');
  }

  get UsuarioNombreUsuario()
  {
    return this.saveForm.get('usuario_nombre_usuario')
  }

  get UsuarioContrasena()
  {
    return this.saveForm.get('usuario_contrasena')
  }

  get UsuarioTelefono()
  {
    return this.saveForm.get('usuario_telefono')
  }

  get UsuarioDireccion()
  {
    return this.saveForm.get('usuario_Direccion')
  }

  get UsuarioAvatar()
  {
    return this.saveForm.get('usuario_Avatar')
  }

  addForm(){
    this.submitted=false;
    this.saveForm.reset();
  }
}

//usuario_nombre_usuario