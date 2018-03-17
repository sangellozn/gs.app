import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CurrentShoppingListComponent } from './current-shopping-list/current-shopping-list.component';
import { ShoppingListService } from './services/shopping-lists.service';
import { AppRoutingModule } from './/app-routing.module';
import { RouterModule } from '@angular/router';
import { ProductsComponent } from './products/products.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProductsService } from './services/products.service';
import { ProductDetailsComponent } from './products/product-details/product-details.component';


@NgModule({
  declarations: [
    AppComponent,
    CurrentShoppingListComponent,
    ProductsComponent,
    NavbarComponent,
    ProductDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [ShoppingListService, ProductsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
