import { ProductoComprado } from './producto-comprado';


export class Producto {

    id:number;
    
    nombre:string;
    
    descripcion:string;
	
	unidades:number;
	
	precio:number;
	
	descuento:number;
	
	imagenes=[];

	videos=[];
	
	productosComprados:ProductoComprado[];
}