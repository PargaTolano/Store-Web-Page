import { Component, OnInit } from '@angular/core';

declare var $: any;
declare var jquery:any;

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  scrollTop()
  {
    $("html, body").animate({ scrollTop: 0 }, "fast");
  }

}
