import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerRentsComponent } from './customer-rents.component';

describe('CustomerRentsComponent', () => {
  let component: CustomerRentsComponent;
  let fixture: ComponentFixture<CustomerRentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerRentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerRentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
