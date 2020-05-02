import { ProductListComponent } from './component/product-list/product-list.component';
import { CmsComponent } from './component/cms/cms.component';
import { AddProductComponent } from './component/add-product/add-product.component';
import { BrowseStoreComponent } from './component/browse-store/browse-store.component';
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
  { path:'product-page/:id'  ,  component:ProductPageComponent   } ,
  { path:'browse-store'      ,  component:BrowseStoreComponent   } ,
  { path:'cms/add-product'       ,  component:AddProductComponent} ,
  { path:'cms'               ,  component:CmsComponent           } ,
  { path: ''                 ,  component:BrowseStoreComponent   } ,
  { path: 'cms/product-list'     ,  component:ProductListComponent   }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }