import { Usuario } from 'src/app/model/usuario';
import { ProductoComprado } from './producto-comprado';
export class CarritoDeCompra {
    
    id:number;
    
    total:number;

    productosComprados:ProductoComprado[];

    usuario:Usuario;
}