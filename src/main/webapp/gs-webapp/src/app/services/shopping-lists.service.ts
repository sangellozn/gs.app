import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { shoppingListsUrls } from './../../assets/url/webservices-urls';
import { Observable } from 'rxjs/Observable';
import { ShoppingList } from '../bean/shopping-list';

@Injectable()
export class ShoppingListService {

  constructor(private http: HttpClient) { }

  getCurrent(): Observable<ShoppingList> {
    return this.http.get<ShoppingList>(shoppingListsUrls.current);
  }

  close() {
    this.http.post(shoppingListsUrls.close, {});
  }

  create(comment: string) {
    this.http.post(shoppingListsUrls.create, { comment });
  }

}
