import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { GithubService } from './github.service';
import { AppComponent } from './app.component';
import { Http, HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { Ng4LoadingSpinnerModule } from 'ng4-loading-spinner';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    Ng4LoadingSpinnerModule.forRoot(),
    HttpClientModule
  ],
  providers: [GithubService],
  bootstrap: [AppComponent]
})
export class AppModule { }
