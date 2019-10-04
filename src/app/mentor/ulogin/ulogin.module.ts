import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { UloginComponent } from './ulogin.component';

@NgModule({
  declarations: [
    UloginComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [UloginComponent]
})
export class AppModule { }
