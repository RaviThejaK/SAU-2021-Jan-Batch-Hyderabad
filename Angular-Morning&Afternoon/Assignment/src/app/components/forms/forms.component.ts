import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormGroupName, Validators, ReactiveFormsModule } from '@angular/forms';
import { ApiCallService } from 'src/app/services/apirequest.service';
import { FormsService } from 'src/app/services/forms.service';
import * as _ from "lodash";

@Component({
  selector: 'app-forms',
  templateUrl: './forms.component.html',
  styleUrls: ['./forms.component.css'],

})
export class FormsComponent implements OnInit {

  constructor(private formsService: FormsService, private apiCallService: ApiCallService) { }



  profile: String = "";
  status: String = "";
  Response: any;
  storedData: any;
  storedData2: any;
  sortbytype: String = "";
  sortorder: boolean;
  datevar: number = Date.now(); // date pipe question

  UserForm: FormGroup = new FormGroup({
    FirstName: new FormControl('', [Validators.required, Validators.minLength(3)]),
    LastName: new FormControl('', [Validators.required, Validators.minLength(3)]),

    EmailId: new FormControl('', [Validators.required, Validators.minLength(3), Validators.pattern('^[^\\s@]+@[^\\s@]+\\.[^\\s@]{2,}$')]),
    Phone: new FormControl('', [Validators.required, Validators.minLength(10), Validators.maxLength(3)]),

  });


  ngOnInit(): void {
    this.storedData2 = this.apiCallService.getUserDetails();
    this.storedData = this.formsService.getUserDetails();
    this.datevar;
    ReactiveFormsModule;
  }

  StoreDetails() {
    // const person: string = this.ProfileForm.value;
    //console.log(person);
    if (this.UserForm.valid) {
      this.formsService.storeUserDetails
        (this.UserForm.get('FirstName')?.value,
          this.UserForm.get('LastName')?.value,
          this.UserForm.get('EmailId')?.value,
          this.UserForm.get('Phone')?.value);
      this.status = "Success";

    }
    else {
      this.status = "Invalid !!!";

    }
    this.storedData = this.formsService.getUserDetails();
  }


  sortdata() {
    this.storedData = _.orderBy(this.storedData, [this.sortbytype], [this.sortorder]); // Use Lodash to sort array

  }

  getApiRequest() {
    this.apiCallService.getUserDetails().subscribe((Response) => {
      this.storedData2 = Response;
    })

  }

}


