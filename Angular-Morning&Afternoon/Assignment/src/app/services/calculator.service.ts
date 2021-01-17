import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  constructor() { }



  add(Input1: number, Input2: number) {
    return Input1 + Input2;
  }

  subtract(Input1: number, Input2: number) {
    return Input1 - Input2;
  }

  multiply(Input1: number, Input2: number) {
    return Input1 * Input2;
  }

  divide(Input1: number, Input2: number) {
    return Input1 / Input2;
  }

}
