import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionaryDetailComponent} from './dictionary-detail/dictionary-detail.component';
import {DictionaryPageComponent} from './dictionary-page/dictionary-page.component';


let routes: Routes = [
  {path: '', component: DictionaryPageComponent},
  {path: ':key', component: DictionaryDetailComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
