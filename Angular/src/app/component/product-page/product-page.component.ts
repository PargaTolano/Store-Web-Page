import { ProductoService } from './../../service/producto.service';
import { Producto } from './../../model/producto';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

declare var $:any;
declare var jquery:any;

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.scss']
})
export class ProductPageComponent implements OnInit{

  private leftValue:number = 0;

  private imgCount:number  = 0;

  private mockMediaBoxes = [

    {'url':'https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png'},
    {'url':'https://cutewallpaper.org/21/video-games-wallpapers-1080p/Gaming-Wallpapers-Top-Free-Gaming-Backgrounds-.jpg'},
    {'url':'https://thewallpaper.co//wp-content/uploads/2016/10/hd-game-backgrounds-1080p-free-download-hd-desktop-wallpapers-amazing-images-background-photos-1080p-free-images-desktop-backgrounds-artworks-ultra-hd-1920x1080.jpg'}
  ];

  private id:string;

  product:Producto = new Producto();

  private mediaWidth:number = 0;

  mediaBoxes:any[];

  constructor(private route:ActivatedRoute, private service:ProductoService) { }

  ngOnInit(): void {
    
    this.id = this.route.snapshot.paramMap.get('id');

    this.service.getById(Number(this.id)).subscribe(data=>{

        this.product = data;

        this.mediaBoxes = [this.product.imagenes]/*.concat([this.product.videos])*/;

        this.imgCount = this.mediaBoxes.length;

        this.mediaWidth = 100 / this.imgCount;

        $("div.media img").css({
          "width":(100/this.mediaWidth)+"%"
        });

    },
    error=>{

      console.log( error);

    });

    this.mediaBoxes = this.mockMediaBoxes;

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
    return this.mediaBoxes[ind].url;
  }
}
