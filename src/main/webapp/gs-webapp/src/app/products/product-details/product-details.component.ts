import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../../bean/product';
import { ProductsService } from '../../services/products.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  private product: Product;

  private productForm: FormGroup;

  private ean13Ctrl: FormControl;
  private nameCtrl: FormControl;
  private descriptionCtrl: FormControl;

  constructor(private route: ActivatedRoute, private productsService: ProductsService) { }

  ngOnInit() {
    // Chargement des données du formulaire.
    this.createForm();
    let id: string = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.productsService.get(id).subscribe(
        response => {this.product = response; this.setFormValue()} ,
        error => console.log(error)
      );
    } else {
      this.product = new Product();
    }
  }

  createForm() {
    this.ean13Ctrl = new FormControl('', [Validators.required, Validators.pattern('[0-9]{13}')]);
    this.nameCtrl = new FormControl('', [Validators.required, Validators.maxLength(100)]);
    this.descriptionCtrl = new FormControl('', [Validators.required, Validators.maxLength(255)])
    this.productForm = new FormGroup({
      ean13: this.ean13Ctrl,
      name: this.nameCtrl,
      description: this.descriptionCtrl
    });
  }

  setFormValue() {
    let {ean13, name, description} = this.product;
    this.productForm.setValue({
      ean13,
      name,
      description
    });
  }

}
