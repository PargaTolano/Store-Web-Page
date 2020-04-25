import { Compra } from './compra';
import { Producto } from './producto';
export class ProductoComprado {

    id:number;

	unidades:number;
	
	costo:number;
	
	producto : Producto;
	
    compra  : Compra;
    
}