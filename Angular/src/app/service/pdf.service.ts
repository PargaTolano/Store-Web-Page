import { PDFFile } from './../model/pdffile';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class PdfService {

  private baseUrl = `${window.location.protocol}//${window.location.hostname}:8080/api/pdf-`;

  constructor(private http:HttpClient){}

  save(pdf:PDFFile, str:string){
    return this.http.post(`${this.baseUrl}save`,  {"pdf":pdf,"base64Str":str});
  }

  update(pdf:PDFFile){
    return this.http.post(`${this.baseUrl}update`, pdf);
  }

  delete(pdf:PDFFile){
    return this.http.post(`${this.baseUrl}delete`, pdf);
  }

  DownloadPDF(pdf:PDFFile){

    let file = new Blob([pdf.contenido], {type: 'application/pdf'});
    let fileURL = URL.createObjectURL(file);

    const a = document.createElement('a');
    a.style.display="none";

    a.href = fileURL;
    a.download = pdf.nombre;
    a.click();
  }

}
