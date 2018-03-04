import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrentShoppingListComponent } from './current-shopping-list.component';

describe('CurrentShoppingListComponent', () => {
  let component: CurrentShoppingListComponent;
  let fixture: ComponentFixture<CurrentShoppingListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CurrentShoppingListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CurrentShoppingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
