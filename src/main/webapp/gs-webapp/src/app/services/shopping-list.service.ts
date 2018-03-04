import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { shoppingListsUrls } from './../../assets/url/shopping-lists';

@Injectable()
export class ShoppingListService {

  constructor(private http: HttpClient) { }

  getCurrent() {
    return this.http.get(shoppingListsUrls.current);
  }

  close() {
    this.http.post(shoppingListsUrls.close, {});
  }

  create(comment: string) {
    this.http.post(shoppingListsUrls.create, { comment });
  }

}
