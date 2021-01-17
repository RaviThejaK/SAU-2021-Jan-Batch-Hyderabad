import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { from, Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ApiCallService {

  constructor(private http: HttpClient) { }

  getUserDetails(): Observable<any> {
    return this.http.get('https://jsonplaceholder.typicode.com/users');
    // .pipe(
    //     catchError(this.handleError<any>('getHeroes', []))
    //  );
  }
}
