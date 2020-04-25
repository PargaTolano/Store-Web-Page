import { ProductPageComponent   } from './component/product-page/product-page.component';
import { ShoppingCartComponent  } from './component/shopping-cart/shopping-cart.component';
import { LogInComponent         } from './component/log-in/log-in.component';
import { SignUpComponent        } from './component/sign-up/sign-up.component';
import { NgModule               } from '@angular/core';
import { Routes, RouterModule   } from '@angular/router';


const routes: Routes = [
  { path:'sign-up'           ,  component:SignUpComponent        } ,
  { path:'log-in'            ,  component:LogInComponent         } ,
  { path:'shopping-cart'     ,  component:ShoppingCartComponent  } ,
  { path:'product-page/:id'  ,  component:ProductPageComponent   }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }