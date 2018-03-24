import { BaseObject } from "./base-object";

export class Product extends BaseObject {

    public name: string;
    public description: string;
    public ean13: string;
    public stockQty: number;
    public minStockQty: number;
    public targetStockQty: number;

}
