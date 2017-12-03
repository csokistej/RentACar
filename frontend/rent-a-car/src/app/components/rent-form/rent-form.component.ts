import { Component, OnInit, OnChanges, Input, Output, EventEmitter  } from '@angular/core'; 
import { Car } from '../../models/Car';
import { Rent } from '../../models/Rent';
import { RentService } from '../../services/rent.service';

@Component({
  selector: 'app-rent-form',
  templateUrl: './rent-form.component.html',
  styleUrls: ['./rent-form.component.css']
})
export class RentFormComponent implements OnInit {

  @Input() rent: Rent
  model: Rent
  @Output() onSubmit = new EventEmitter<Rent>();


  constructor() { }

  ngOnInit() {
  }

  ngOnChanges() {
    this.model = Object.assign({}, this.rent);
  }

  submit(form){
    if(!form.valid){
      return;
    }
    this.onSubmit.emit(this.model);
  }

}
