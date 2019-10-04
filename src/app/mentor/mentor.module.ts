import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { MentorComponent } from './mentor.component';
import { MprogressComponent } from './mprogress/mprogress.component';

@NgModule({
  declarations: [
    MentorComponent,
    MprogressComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [MentorComponent]
})
export class AppModule { }
