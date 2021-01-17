import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FormsService {

  constructor() { }

  userArray: any = [];
  data: any;
  saveUserToLocal(FirstName: string, LastName: string, EmailId: string, Phone: number) {
    this.userArray.push({ FirstName: FirstName, LastName: LastName, EmailId: EmailId, Phone: Phone });
    localStorage.setItem('newUser', JSON.stringify(this.userArray));
  }

  getUserDetails() {
    this.data = localStorage.getItem('newUser');
    if (this.data != null) {
      console.log(JSON.parse(this.data));
      return JSON.parse(this.data);
    }
    else
      console.log("Not Available");
  }
}
