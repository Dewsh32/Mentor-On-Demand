import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { MsignupComponent } from './msignup.component';

@NgModule({
  declarations: [
    MsignupComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [MsignupComponent]
})
export class AppModule { }
