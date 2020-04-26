import { Video } from './video';
import { Imagen } from './imagen';
import { ProductoComprado } from './producto-comprado';


export class Producto {

    id:number;
    
    nombre:string;
    
    descripcion:string;
	
	unidades:number;
	
	precio:number;
	
	descuento:number;
	
	imagenes:Imagen[];

	videos:Video[];
	
	productosComprados:ProductoComprado[];
}