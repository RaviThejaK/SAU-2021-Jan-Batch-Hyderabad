import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReactiveformsService {

  constructor() { }

  userArray: any = [];
  data: any = '';
  saveUserToLocal(FirstName: string, LastName: string, EmailId: string) {
    this.userArray.push({ FirstName: FirstName, LastName: LastName, EmailId: EmailId });
    localStorage.setItem('newUser', JSON.stringify(this.userArray));
  }

  getUserDetails() {
    this.data = localStorage.getItem('newUser');
    if (this.data != null) {
      console.log(JSON.parse(this.data));
      return JSON.parse(this.data);
    }
    else
      console.log("No ");
  }
}
