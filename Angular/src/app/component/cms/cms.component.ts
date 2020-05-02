import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

declare var jQuery:any;
declare var $:any;

@Component({
  selector: 'app-cms',
  templateUrl: './cms.component.html',
  styleUrls: ['./cms.component.scss']
})
export class CmsComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
    $(window).scroll(function(e)
    {
      let y = $(this).scrollTop();

      if(y > this.lastScroll)
      {
        var x = document.getElementById("cms");
        if (x.className === "cms responsive") {
          x.className = "cms";
        }
          $(".cms").css({"top":"-55px"});
      }
      else if(y < this.lastScroll)
      {
        $(".cms").css( {"top":"0"});
      }
      this.lastScroll = y;
    });
    
  }
   
  navAddProduct(){
    this.router.navigate(['add-product']);
  }
  
}
function openNav() {
  document.getElementById("cms").style.width = "250px";
}
function closeNav() {
  document.getElementById("cms").style.width = "0";
}


