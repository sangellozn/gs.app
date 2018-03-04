import { ShoppingListItem } from "./shopping-list-item";

export enum ShoppingListState { OPENED, CLOSED };

export class ShoppingList {

    public comment: string;
    public state: ShoppingListState;
    public shoppingListItems: ShoppingListItem[];

}
