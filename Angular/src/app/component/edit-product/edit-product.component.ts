import { ImagenService } from './../../service/imagen.service';
import { PDFFile } from './../../model/pdffile';
import { Producto } from './../../model/producto';
import { ProductoService } from './../../service/producto.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Imagen } from 'src/app/model/imagen';

declare var $:any;
declare var jquery:any;

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.scss']
})
export class EditProductComponent implements OnInit {

  constructor(private ProductoService:ProductoService,private imagenService:ImagenService) { }

  producto:Producto;

  submitted:boolean = false;

  imageUploaded:boolean = false;

  file:File;

  placeholderImg:string = 'https://via.placeholder.com/400';

  mock = { url:this.placeholderImg};

  fileName:string;

  imageSrc:string;

  private leftValue:number = 0;

  imgCount:number  = 0;

  mediaBoxes:Imagen[];

  ngOnInit(): void {
    this.submitted = false;
    this.producto = new Producto();
    this.producto.imagenes = <Imagen[]>[];
    this.producto.imagenes[0] = new Imagen();
    this.producto.pdf = new PDFFile();
  }

  saveForm  =               new FormGroup({
    producto_nombre:        new FormControl(null , [ Validators.required ]                     ),
    producto_descripcion:   new FormControl(null , [ Validators.required ]                     ),
    producto_unidades:      new FormControl(null , [ Validators.required , Validators.min(0)]  ),
    producto_precio:        new FormControl(null , [ Validators.required , Validators.min(0)]  ),
    producto_pdf:           new FormControl(null , [ Validators.required ]                     ),
    producto_imagen:        new FormControl(null , [ Validators.required ]                     )
  });

  SaveId(saveid){
    this.producto=new Producto();   
    this.producto.id             = this.Productoid        .value;
    this.producto.nombre         = this.ProductoNombre    .value;
    this.producto.descripcion    = this.ProductoDescripcion    .value;
    this.producto.unidades       = this.ProductoUnidades  .value;
    this.submitted = true;
    this.save();
  }
  
  save() {
    this.ProductoService.save(this.producto)
      .subscribe(data => console.log(data), error => console.log(error));
  }

  get Productoid(){
    return this.saveForm.get('producto_id');
  }

  get ProductoNombre(){
    return this.saveForm.get('producto_nombre');
  }

  get ProductoDescripcion(){
    return this.saveForm.get('producto_descripcion');
  }

  get ProductoUnidades()
  {
    return this.saveForm.get('producto_unidades');
  }

  get ProductoPrecio()
  {
    return this.saveForm.get('producto_precio');
  }

  get ProductoImagenes()
  {
    return this.saveForm.get('producto_imagen');
  }

  get ProductoPDF()
  {
    return this.saveForm.get('producto_pdf');
  }

  addForm(){
    this.submitted=false;
    this.saveForm.reset();
  }

  onFileChangeImage(event) {
    const urlReader  = new FileReader();
    const byteReader = new FileReader();
    
    if(event.target.files && event.target.files.length) {
      const file = event.target.files[0];
      byteReader.readAsArrayBuffer(file);
      byteReader.onload = () => {
        
        this.producto.imagenes[0].bytes = new Int8Array(byteReader.result as ArrayBuffer);
        console.log(this.producto.imagenes[0]);
   
      };

      urlReader.readAsDataURL(file);
      urlReader.onload = () => {
        
        this.imageSrc = urlReader.result as string;
        console.log(this.imageSrc)
      };
   
    }
    else
      this.imageSrc = undefined;
  }

  onFileChangePDF(event) {
    const reader = new FileReader();

    if(event.target.files && event.target.files.length) {
      const file = event.target.files[0];
      reader.readAsArrayBuffer(file);
      
      
      reader.onload = () => {
      
        this.producto.pdf.nombre      = file.name;
        this.producto.pdf.contenido    = new Int8Array(reader.result as ArrayBuffer);
        console.log(this.producto.pdf)
        
      };
   
    }
  }

  circleClick(i,event){
    this.leftValue= i*-100;
    this.carrousselScroll(this.leftValue);
  }

  updateDot(ind)
  {
    $("ol li").css('opacity',0.5);
    $("ol li").each((index,value)=>{
      if(index===ind)
        $(value).css('opacity',1);
    });
  }

  carrousselScroll(leftValue:number)
  {
    this.updateDot(Math.floor(leftValue/-100));
    $('#slide ul').css({
      'left':leftValue+"%"
    });
  }

  getImageUrl(ind):string
  {
    return this.imagenService.imagenUrlUrl(this.mediaBoxes[ind]);
  }
}
