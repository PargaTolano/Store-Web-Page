import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

declare var jQuery:any;
declare var $:any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  title = 'Angular';

  lastScroll:number;

  constructor(private router:Router){}

  ngOnInit(): void {
    
    let height = $('div#myTopnav').css('height');

    let heightNum = Number.parseInt(height) + 10;

    $('#main').css({
      'padding-top':heightNum+"px"
    });
  }

  myFunction(){
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
      x.className += " responsive";
    } else {
      x.className = "topnav";
    }
  }
}
