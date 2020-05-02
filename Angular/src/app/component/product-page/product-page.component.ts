import { PdfService } from './../../service/pdf.service';
import { ImagenService } from './../../service/imagen.service';
import { ProductoService } from './../../service/producto.service';
import { Producto } from './../../model/producto';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Imagen } from 'src/app/model/imagen';

declare var $:any;
declare var jquery:any;

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.scss']
})
export class ProductPageComponent implements OnInit{

  private leftValue:number = 0;

  imgCount:number  = 0;

  product:Producto = new Producto();

  private mediaWidth:number = 0;

  mediaBoxes:Imagen[];

  constructor(private route:ActivatedRoute, private service:ProductoService, private imagenService:ImagenService, private pdfService:PdfService) { }

  ngOnInit(): void {
    
    let id = this.route.snapshot.paramMap.get('id');

    this.service.getById(Number(id)).subscribe(data=>{

        this.product = data;

        this.mediaBoxes = this.product.imagenes;

        this.imgCount = this.mediaBoxes.length;

        this.mediaWidth = 100 / this.imgCount;

        $("div.media img").css({
          "width":(100/this.mediaWidth)+"%"
        });
      
        $("#retroceder").click(event=>{
          if(this.leftValue < 0 )
          {
            this.leftValue+=100;
          }
          this.carrousselScroll(this.leftValue);
        });
      
        $("#avanzar").   click(event=>{
          if(this.leftValue > -(this.imgCount-1) * 100)
          {
            this.leftValue-=100;
          }
          this.carrousselScroll(this.leftValue);
        });
    },
    error=>{

      console.log( error);

    });
  }

  Descargar(){
    this.pdfService.byProducto(this.product).subscribe(data=>{

      let fn = function _base64ToArrayBuffer(base64:string) {
        var binary_string = window.atob(base64);
        var len = binary_string.length;
        var bytes = new Uint8Array(len);
        for (var i = 0; i < len; i++) {
            bytes[i] = binary_string.charCodeAt(i);
        }
        return bytes.buffer;
        }
      
      let byteArr:ArrayBuffer = fn(data.encoded);

      this.pdfService.DownloadAsPDF(data.pdf.nombre, byteArr);
    },error=>console.log(error));
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
    return this.imagenService.imagenUrl(this.mediaBoxes[ind]);
  }
  
}

  