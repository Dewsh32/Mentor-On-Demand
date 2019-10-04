import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { MloginComponent } from './mlogin.component';

@NgModule({
  declarations: [
    MloginComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [MloginComponent]
})
export class AppModule { }
