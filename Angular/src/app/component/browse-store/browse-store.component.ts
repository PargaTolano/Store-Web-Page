import { HttpClient } from '@angular/common/http';
import { Imagen } from './../../model/imagen';
import { ImagenService } from './../../service/imagen.service';
import { ProductoService } from './../../service/producto.service';
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
    pdf:null,
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
    pdf:null,
    productosComprados:[]

  },
  {
    id:3,
    nombre:'El principito',
    descripcion: 'Un libro muy wholesome',
    unidades: 15,
    precio: 5.90,
    descuento:0,
    imagenes:[],
    videos:[],
    pdf:null,
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
    pdf:null,
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
    pdf:null,
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
    pdf:null,
    productosComprados:[]

  },
  {
    id:7,
    nombre:'El principito',
    descripcion: 'Un libro muy wholesome',
    unidades: 15,
    precio: 5.90,
    descuento:0,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]
  
  },
  {
    id:8,
    nombre:'El principito 2',
    descripcion: 'Ahora es personal',
    unidades: 15,
    precio: 5.91,
    descuento:10,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]

  },
  {
    id:9,
    nombre:'El principito',
    descripcion: 'Un libro muy wholesome',
    unidades: 15,
    precio: 5.90,
    descuento:0,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]
  
  },
  {
    id:10,
    nombre:'El principito 2',
    descripcion: 'Ahora es personal',
    unidades: 15,
    precio: 5.91,
    descuento:10,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]

  },
  {
    id:11,
    nombre:'El principito',
    descripcion: 'Un libro muy wholesome',
    unidades: 15,
    precio: 5.90,
    descuento:0,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]
  
  },
  {
    id:12,
    nombre:'El principito 2',
    descripcion: 'Ahora es personal',
    unidades: 15,
    precio: 5.91,
    descuento:10,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]

  },{
    id:13,
    nombre:'El principito',
    descripcion: 'Un libro muy wholesome',
    unidades: 15,
    precio: 5.90,
    descuento:0,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]
  
  },
  {
    id:14,
    nombre:'El principito 2',
    descripcion: 'Ahora es personal',
    unidades: 15,
    precio: 5.91,
    descuento:10,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]

  },
  {
    id:15,
    nombre:'El principito',
    descripcion: 'Un libro muy wholesome',
    unidades: 15,
    precio: 5.90,
    descuento:0,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]
  
  },
  {
    id:16,
    nombre:'El principito 2',
    descripcion: 'Ahora es personal',
    unidades: 15,
    precio: 5.91,
    descuento:10,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]

  },{
    id:17,
    nombre:'El principito',
    descripcion: 'Un libro muy wholesome',
    unidades: 15,
    precio: 5.90,
    descuento:0,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]
  
  },
  {
    id:18,
    nombre:'El principito 2',
    descripcion: 'Ahora es personal',
    unidades: 15,
    precio: 5.91,
    descuento:10,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]

  },
  {
    id:19,
    nombre:'El principito',
    descripcion: 'Un libro muy wholesome',
    unidades: 15,
    precio: 5.90,
    descuento:0,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]
  
  },
  {
    id:20,
    nombre:'El principito 2',
    descripcion: 'Ahora es personal',
    unidades: 15,
    precio: 5.91,
    descuento:10,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]

  },
  {
    id:21,
    nombre:'El principito',
    descripcion: 'Un libro muy wholesome',
    unidades: 15,
    precio: 5.90,
    descuento:0,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]
  
  },
  {
    id:22,
    nombre:'El principito 2',
    descripcion: 'Ahora es personal',
    unidades: 15,
    precio: 5.91,
    descuento:10,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]

  },
  {
    id:23,
    nombre:'El principito',
    descripcion: 'Un libro muy wholesome',
    unidades: 15,
    precio: 5.90,
    descuento:0,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]
  
  },
  {
    id:24,
    nombre:'El principito 2',
    descripcion: 'Ahora es personal',
    unidades: 15,
    precio: 5.91,
    descuento:10,
    imagenes:[],
    videos:[],
    pdf:null,
    productosComprados:[]

  }];

  imagenesMock= [
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg',
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg',
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg',
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg',
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg',
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg',
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg',
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg',
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg',
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg',
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg',
    'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',
    'https://bukovero.com/wp-content/uploads/2016/07/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg'
  ];

  constructor(
    private router:         Router,
    private productoService:ProductoService,
    private imagenService:  ImagenService,private http:HttpClient) { }

  ngOnInit(): void {
    
    this.productoService.getAll().subscribe(data=>{

      this.productos = data;

      this.productos.forEach((value,index)=>{
        console.log(value);
      })

    },error=>console.log(error));
  }

  imageUrl(producto:Producto):string
  {
    let a:string = "";
    this.imagenService.getByAllByProduct(producto).subscribe(data=>{

      a = this.imagenService.imagenUrl(data[0]);

    })

    return a;
  }

  imageUrlUrl(imagen:Imagen):string
  {
    let a = this.imagenService.imagenUrlUrl(imagen);

    return a;
  }

  productPage(id:number)
  {
    this.router.navigate([`/product-page/${id}`]);
  }

}
