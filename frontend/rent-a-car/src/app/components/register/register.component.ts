import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import { Customer } from '../../models/Customer';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  @Input() customer: Customer
  model: Customer
  @Output() onSubmit = new EventEmitter<Customer>();
  
  constructor() { 
    this.model.userName = "Pff"
  }

  ngOnInit() {
  }

  ngOnChanges(){
    this.model = Object.assign({}, this.customer);
  }

  submit(form) {
    if(!form.valid){
      return;
    }
    this.onSubmit.emit(this.model);
  }

}
