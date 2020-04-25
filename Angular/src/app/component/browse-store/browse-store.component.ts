import { Router } from '@angular/router';
import { Producto } from './../../model/producto';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-browse-store',
  templateUrl: './browse-store.component.html',
  styleUrls: ['./browse-store.component.scss']
})
export class BrowseStoreComponent implements OnInit {

  productos:Producto[] = [];

  prodcutosMock:Producto[] = [{
    id:1,
    nombre:'El principito',
    descripcion: 'Un libro muy wholesome',
    unidades: 15,
    precio: 5.90,
    descuento:0,
    imagenes:[],
    videos:[],
    productosComprados:[]
  
  },
  {
    id:2,
    nombre:'El principito 2',
    descripcion: 'Ahora es personal',
    unidades: 15,
    precio: 5.91,
    descuento:10,
    imagenes:[],
    videos:[],
    productosComprados:[]

  },{
    id:3,
    nombre:'El principito',
    descripcion: 'Un libro muy wholesome',
    unidades: 15,
    precio: 5.90,
    descuento:0,
    imagenes:[],
    videos:[],
    productosComprados:[]
  
  },
  {
    id:4,
    nombre:'El principito 2',
    descripcion: 'Ahora es personal',
    unidades: 15,
    precio: 5.91,
    descuento:10,
    imagenes:[],
    videos:[],
    productosComprados:[]

  },{
    id:5,
    nombre:'El principito',
    descripcion: 'Un libro muy wholesome',
    unidades: 15,
    precio: 5.90,
    descuento:0,
    imagenes:[],
    videos:[],
    productosComprados:[]
  
  },
  {
    id:6,
    nombre:'El principito 2',
    descripcion: 'Ahora es personal',
    unidades: 15,
    precio: 5.91,
    descuento:10,
    imagenes:[],
    videos:[],
    productosComprados:[]

  }];

  imagenesMock= [
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg',
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg',
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg'
  ];

  constructor(private router:Router) { }

  ngOnInit(): void {
    this.productos= this.prodcutosMock;
  }

  productPage(id:number)
  {
    this.router.navigate([`/product-page/${id}`]);
  }

}
