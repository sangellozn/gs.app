import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductsComponent } from './products/products.component';
import { CurrentShoppingListComponent } from './current-shopping-list/current-shopping-list.component';
import { ProductDetailsComponent } from './products/product-details/product-details.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'products', component: ProductsComponent},
  {path: 'products/:id', component: ProductDetailsComponent},
  {path: 'home', component: CurrentShoppingListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
