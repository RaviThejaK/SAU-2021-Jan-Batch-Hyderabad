import { Component, OnInit } from '@angular/core';
//import { Router } from '@angular/router';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { CalculatorService } from 'src/app/services/calculator.service';


@Component({
    selector: 'app-calculator',
    templateUrl: './calculator.component.html',
    styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {


    constructor(private calculatorService: CalculatorService, private router: ActivatedRoute) { }


    title = 'Calculator';
    Input1: number = 0;
    Input2: number = 0;
    Result: number;

    ngOnInit(): void {
        this.Result;
    }

    addition() {
        this.Result = this.calculatorService.add(this.Input1, this.Input2);
    }
    subtraction() {
        this.Result = this.calculatorService.subtract(this.Input1, this.Input2);
    }
    multiplication() {
        this.Result = this.calculatorService.multiply(this.Input1, this.Input2);
    }
    division() {
        this.Result = this.calculatorService.divide(this.Input1, this.Input2);
    }


}
