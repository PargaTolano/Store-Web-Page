import { Producto } from './../../model/producto';
import { ImagenService } from './../../service/imagen.service';
import { ProductoService } from './../../service/producto.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  productos:Producto[];

  constructor(private productoService:ProductoService,
    private imagenService:ImagenService) { }

  ngOnInit(): void {
    this.productoService.getAll().subscribe(data=>this.productos = data, error=>console.log(error));
  }

  getUrl(producto:Producto):string
  {
    console.log(producto.imagenes[0])
    return this.imagenService.imagenUrl(producto.imagenes[0]);
  }

  Editar(producto){}

  Delete(producto){}
}
