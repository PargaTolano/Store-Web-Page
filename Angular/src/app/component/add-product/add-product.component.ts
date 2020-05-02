import { PdfService } from './../../service/pdf.service';
import { ImagenService } from './../../service/imagen.service';
import { PDFFile } from './../../model/pdffile';
import { Producto } from './../../model/producto';
import { ProductoService } from './../../service/producto.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Imagen } from 'src/app/model/imagen';


@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss']
})
export class AddProductComponent implements OnInit {

  constructor(private ProductoService:ProductoService,
    private imagenService:ImagenService,
    private pdfService:PdfService) { }

  producto:Producto;

  pdf:PDFFile;

  imagen:Imagen;

  submitted:boolean = false;

  imageUploaded:boolean = false;

  file:File;

  placeholderImg:string = 'https://via.placeholder.com/400';

  mock = { url:this.placeholderImg};

  fileName:string;

  imageSrc:string;

  ngOnInit(): void {
    this.submitted = false;
    this.pdf = new PDFFile();
    this.imagen = new Imagen();
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
    this.producto.nombre         = this.ProductoNombre     .value;
    this.producto.descripcion    = this.ProductoDescripcion.value;
    this.producto.unidades       = this.ProductoUnidades   .value;
    this.producto.precio         = this.ProductoPrecio     .value;
    this.producto.imagenes       = null;
    this.producto.pdf            = null;
    this.save();
  }
  
  bArrToB64( buffer ) {
    var binary = '';
    var bytes = new Uint8Array( buffer );
    var len = bytes.byteLength;
    for (var i = 0; i < len; i++) {
        binary += String.fromCharCode( bytes[ i ] );
    }
    return window.btoa( binary );
  }

  save() {
    this.ProductoService.save(this.producto)
      .subscribe(data =>{

        let b64str:string  = this.bArrToB64(this.imagen.bytes) as string;
    
        this.imagen.id = 13213213;
        this.imagen.producto = data;
        this.imagenService.save(this.imagen,b64str)
          .subscribe(data =>{
            console.log(data)}, error => console.log(error));

        let b64str2 = this.bArrToB64(this.pdf.contenido) as string;
            
        this.pdf.id = 13213;
        this.pdf.producto = data;
        this.pdfService.save(this.pdf,b64str2)
          .subscribe(data =>{
            console.log(data)}, error => console.log(error));

      }, error => console.log(error));
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
        this.imagen.bytes = new Int8Array(byteReader.result as ArrayBuffer);
      };

      urlReader.readAsDataURL(file);
      urlReader.onload = () => {
        this.imageSrc = urlReader.result as string;
      };
   
    }
    else{
      this.imagen   = undefined;
      this.imageSrc = undefined;
    }
  }

  onFileChangePDF(event) {
    const reader = new FileReader();

    if(event.target.files && event.target.files.length) {
      const file = event.target.files[0];
      reader.readAsArrayBuffer(file);
      
      
      reader.onload = () => {
      
        this.pdf.nombre       = file.name;
        this.pdf.contenido    = new Int8Array(reader.result as ArrayBuffer);
        
      };
   
    }
    else{
      this.pdf = null;
    }
  }
}
