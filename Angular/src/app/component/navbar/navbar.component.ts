import { Component, OnInit } from '@angular/core';

declare var jQuery:any;
declare var $:any;

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {

    $(window).scroll(function(e)
    {
      let y = $(this).scrollTop();

      if(y > this.lastScroll)
      {
        var x = document.getElementById("myTopnav");
        if (x.className === "topnav responsive") {
          x.className = "topnav";
        }
          $(".topnav").css({"top":"-55px"});
      }
      else if(y < this.lastScroll)
      {
        $(".topnav").css( {"top":"0"});
      }
      this.lastScroll = y;
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
