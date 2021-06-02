import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TodoComponent } from './thuchanh/todo/todo.component';
import {ReactiveFormsModule} from "@angular/forms";
import { RegisterComponent } from './baitap/register/register.component';
import { LoginComponent } from './baitap/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoComponent,
    RegisterComponent,
    LoginComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
