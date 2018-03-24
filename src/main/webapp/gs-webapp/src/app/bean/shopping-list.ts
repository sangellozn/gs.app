import { ShoppingListItem } from "./shopping-list-item";
import { BaseObject } from "./base-object";

export enum ShoppingListState { OPENED, CLOSED };

export class ShoppingList extends BaseObject {

    public comment: string;
    public state: ShoppingListState;
    public shoppingListItems: ShoppingListItem[];

}
