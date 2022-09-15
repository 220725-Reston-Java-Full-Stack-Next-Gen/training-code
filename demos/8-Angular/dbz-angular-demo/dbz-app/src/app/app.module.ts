import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { CorsInterceptorService } from './services/cors-interceptor.service';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap'
import { MdbModalModule } from 'mdb-angular-ui-kit/modal';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AboutComponent } from './components/about/about.component';
import { SearchComponent } from './components/search/search.component';
import { BrowseComponent } from './components/browse/browse.component';
import { ViewAllComponent } from './components/blogs/view-all/view-all.component';
import { CreateComponent } from './components/blogs/create/create.component';

//This module is responsible for grouping together all of the components in the app and imports all additional modules needed for the app
@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    NavbarComponent,
    AboutComponent,
    SearchComponent,
    BrowseComponent,
    ViewAllComponent,
    CreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    MdbModalModule
  ],
  //here is where we would provide the interceptors needed for the app
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: CorsInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
