import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import { Router } from "@angular/router";
import { AuthService } from "../../services/auth.service";
import { Customer } from '../../models/Customer';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  //@Input() customer: Customer
  model: Customer = new Customer();
 // @Output() onSubmit = new EventEmitter<Customer>();

  message: string = '';
  
  constructor(
    private authService: AuthService,
    private router: Router
  ) {
  }

  ngOnInit() {
  }

  /*ngOnChanges(){
    this.model = Object.assign({}, this.customer);
  }*/

  async submit(form) {
    if (form.invalid) {
      return;
    }
    try {
      this.message = 'Try to register';
      await this.authService.register(this.model);
      console.log('success')
      this.router.navigate([this.authService.redirectUrl]);
    }
    catch(e) {
      this.message = 'Register failed';
      console.log(e);
    }
  }

}
