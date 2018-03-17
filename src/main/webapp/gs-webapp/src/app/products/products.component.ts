import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../services/products.service';
import { Product } from '../bean/product';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  public products: Product[];

  private currentPage: number = 0;
  private currentLimit: number = 20;
  private currentOrder: string = 'name';

  constructor(private productsServices: ProductsService) { }

  ngOnInit() {
    this.productsServices.getPage(this.currentPage, this.currentLimit, this.currentOrder)
      .subscribe(
        response => this.products = response.data, 
        error => console.error(error)
      );
  }

}
