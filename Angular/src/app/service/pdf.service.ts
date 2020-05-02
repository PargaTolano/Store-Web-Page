import { Observable } from 'rxjs';
import { Producto } from './../model/producto';
import { PDFFile } from './../model/pdffile';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class PdfService {

  private baseUrl = `${window.location.protocol}//${window.location.hostname}:8080/api/pdf-`;

  constructor(private http:HttpClient){}

  save(pdf:PDFFile, str:string){
    pdf.contenido = null;
    return this.http.post(`${this.baseUrl}save`,  {"pdf":pdf,"base64Str":str});
  }

  update(pdf:PDFFile){
    return this.http.post(`${this.baseUrl}update`, pdf);
  }

  delete(pdf:PDFFile){
    return this.http.post(`${this.baseUrl}delete`, pdf);
  }

  byProducto(p:Producto):Observable<any>
  {
    return this.http.post(`${this.baseUrl}product`,p);
  }

  byProductoBlob(p:Producto):Observable<any>{
    return this.http.post(`${this.baseUrl}product-blob`,p);
  }

  DownloadAsPDF(nombre:string,arr:ArrayBuffer)
  {
    var file = new Blob([arr], {type: 'application/pdf'});
    var fileURL = URL.createObjectURL(file);
    
    const a = document.createElement('a');
    a.style.display="none";

    a.href = fileURL;
    a.download = nombre;
    a.click();
  }

}
