import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StocksListingComponent } from './stocks-listing/stocks-listing.component';
import {StocksService} from "./stocks.service"

@NgModule({
  declarations: [
    AppComponent,
    StocksListingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [StocksService],
  bootstrap: [AppComponent]
})
export class AppModule { }
