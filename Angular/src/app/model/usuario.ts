import { CarritoDeCompra } from './carrito-de-compra';
import { Compra } from './compra';
export class Usuario {

    id:number;

    nombre:string;

    apellido:string;

    correo:string;

    nombreUsuario:string;

    contrasena:string;

    telefono:number;

    direccion:string;

    avatar:Int8Array;

    compras:Compra[];

    carritoDeCompra:CarritoDeCompra;

    constructor(obj?: any) {
        Object.assign(this, obj);
    }
}