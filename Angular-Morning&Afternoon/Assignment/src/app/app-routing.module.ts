import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CalculatorComponent } from './components/calculator/calculator.component';
import { FormsComponent } from './components/forms/forms.component';

const routes: Routes = [
  { path: 'calculator', component: CalculatorComponent },
  { path: 'forms', component: FormsComponent },
  { path: '**', component: CalculatorComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
