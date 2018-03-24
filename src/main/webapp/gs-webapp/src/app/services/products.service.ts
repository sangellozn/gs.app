import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Product } from '../bean/product';

import { productsUrls } from './../../assets/url/webservices-urls';
import { ProductPage } from '../bean/product-page';

@Injectable()
export class ProductsService {

  constructor(private http: HttpClient) { }

  getPage(p?: number, l?: number, o?: string): Observable<ProductPage> {
    return this.http.get<ProductPage>(productsUrls.getPage, { params: {p: String(p), l: String(l), o}});
  }

  get(id: string): Observable<Product> {
    return this.http.get<Product>(productsUrls.get.replace('{id}', id));
  }


}
