import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LogInComponent } from './component/log-in/log-in.component';
import { SignUpComponent } from './component/sign-up/sign-up.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NavbarComponent } from './component/navbar/navbar.component';
import { LandingPageComponent } from './component/landing-page/landing-page.component';
import { ShoppingCartComponent } from './component/shopping-cart/shopping-cart.component';
import { ProductPageComponent } from './component/product-page/product-page.component';
import { AddProductComponent } from './component/add-product/add-product.component';

@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
    SignUpComponent,
    NavbarComponent,
    LandingPageComponent,
    ShoppingCartComponent,
    ProductPageComponent,
    AddProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
