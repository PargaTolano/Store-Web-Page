import { Usuario } from 'src/app/model/usuario';
import { ProductoComprado } from './producto-comprado';
export class Compra {

    id:number;

    fecha:Date;

    lugar_entrega:string;
    
    total:number;

    productosComprados:ProductoComprado[];
    
    usuario:Usuario;
}
