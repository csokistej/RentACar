import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import { Rent } from '../../models/Rent';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  @Input() rent: Rent
  model: Rent = new Rent();
  @Output() onSubmit = new EventEmitter<Rent>();

  constructor() { }

  ngOnInit() {
  }

  ngOnChanges(){
    this.model = Object.assign({}, this.rent);
  }

  submit(form) {
    if(!form.valid){
      return;
    }
    this.onSubmit.emit(this.model);
    console.log(this.model) //Itt van a Customer ha kell valamire
  }

}