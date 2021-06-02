import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontSizeEditorComponent } from './font-size-editor/font-size-editor.component';
import {FormsModule} from '@angular/forms';
import { ShowPetComponent } from './show-pet/show-pet.component';
import { InstallBootstrapComponent } from './install-bootstrap/install-bootstrap.component';


@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    ShowPetComponent,
    InstallBootstrapComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
