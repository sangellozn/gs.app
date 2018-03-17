import { Component, OnInit } from '@angular/core';
import { ShoppingList } from '../bean/shopping-list';
import { ShoppingListService } from '../services/shopping-lists.service';

@Component({
  selector: 'app-current-shopping-list',
  templateUrl: './current-shopping-list.component.html',
  styleUrls: ['./current-shopping-list.component.css']
})
export class CurrentShoppingListComponent implements OnInit {

  private currentShoppingList: ShoppingList;

  constructor(private shoppingListsService: ShoppingListService) { }

  ngOnInit() {
    this.shoppingListsService.getCurrent()
      .subscribe(
        data => this.currentShoppingList = data, 
        error => console.error(error)
      );
  }

}
