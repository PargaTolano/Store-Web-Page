import { PdfService } from './service/pdf.service';
import { ImagenService } from './service/imagen.service';
import { ProductoService } from './service/producto.service';
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
import { BrowseStoreComponent } from './component/browse-store/browse-store.component';
import { FooterComponent } from './component/footer/footer.component';
import { CmsComponent } from './component/cms/cms.component';
import { EditProductComponent } from './component/edit-product/edit-product.component';
import { ProductListComponent } from './component/product-list/product-list.component';

@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
    SignUpComponent,
    NavbarComponent,
    LandingPageComponent,
    ShoppingCartComponent,
    ProductPageComponent,
    AddProductComponent,
    BrowseStoreComponent,
    FooterComponent,
    CmsComponent,
    EditProductComponent,
    ProductListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ProductoService,
              ImagenService,
              PdfService],
  bootstrap: [AppComponent]
})
export class AppModule { }
