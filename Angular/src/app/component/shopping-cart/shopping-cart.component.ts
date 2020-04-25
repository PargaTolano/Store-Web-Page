import { Usuario } from 'src/app/model/usuario';
import { Compra } from './../../model/compra';
import { Producto } from './../../model/producto';
import { ProductoComprado } from './../../model/producto-comprado';
import { CarritoDeCompra } from './../../model/carrito-de-compra';
import { Component, OnInit, Input } from '@angular/core';

import { ActivatedRoute } from '@angular/router';


@Component({
	selector: 'app-shopping-cart',
	templateUrl: './shopping-cart.component.html',
	styleUrls: ['./shopping-cart.component.scss']
  })
export class ShoppingCartComponent implements OnInit {

	//private pruducts:ProductComprado[];

	productosCompradosMock: ProductoComprado[] = 
	[
		{
			id:0,
			unidades:10,
			costo:5.0,
			compra:new Compra(),
			producto:
			{
				id:0,
				nombre:"Libro",
				descripcion:"pito pito pito pito pito pito pito pito pito pito pito pito pito pito pito pito pito pito pito pito pito pito pito pito",
				unidades:10,
				precio:10.0,
				descuento: 50,
				imagenes:null,
				videos:null,
				productosComprados:null
			}
		},
		{
			id:1,
			unidades:17,
			costo:25.0,
			compra:new Compra(),
			producto:
			{
				id:1,
				nombre:"Otro Libro",
				descripcion:"ñonga ñonga ñonga ñonga ñonga ñonga ñonga ñonga",
				unidades:44,
				precio:22.0,
				descuento: 2,
				imagenes:null,
				videos:null,
				productosComprados:null
			}
		}
	];

	carrito:CarritoDeCompra = {

		id:0,
    
    	total:1010,

    	productosComprados:this.productosCompradosMock,

   		usuario:new Usuario()

	};

	constructor(
		private activatedRoute: ActivatedRoute,
	) { }

	ngOnInit():void{

		this.carrito.productosComprados = this.productosCompradosMock;


	}

	add(i)
	{
		let uni = this.carrito.productosComprados[i].unidades;
		if (uni < this.carrito.productosComprados[i].producto.unidades)
		{
			this.carrito.productosComprados[i].unidades++;
		}
	}

	substract(i)
	{
		let uni = this.carrito.productosComprados[i].unidades;
		if (uni > 0)
		{
			this.carrito.productosComprados[i].unidades--;
		}
	}

	focusOut(i,unidades)
	{
		if(this.carrito.productosComprados[i].unidades > this.carrito.productosComprados[i].producto.unidades)
		{
			this.carrito.productosComprados[i].unidades = this.carrito.productosComprados[i].producto.unidades;
		}
		else if(this.carrito.productosComprados[i].unidades < 0)
		{
			this.carrito.productosComprados[i].unidades = 0;
		}
	}
	
	key(i, unidades, event)
	{
		const charCode = (event.which) ? event.which : event.keyCode;
    	if (charCode > 31 && (charCode < 48 || charCode > 57))
    	  console.log("Letra : " + charCode );
    	else
			this.focusOut(i,unidades);

	}

  	remove(i):void {
	if (i > -1) {
		this.carrito.productosComprados.splice(i, 1);
	}
  	}
  
  
  	loadCart(): void 
  	{
	
  	}
  }
	