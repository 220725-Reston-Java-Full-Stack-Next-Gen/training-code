import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

//here is where we would define our routes
const routes: Routes = [
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "register",
    component: RegisterComponent
  },
  {
    path: "home",
    component: HomeComponent
  },
  //here is where you can define a default path for when the user either doesn't provide a valid path or no path at all
  {
    path: "",
    redirectTo: '/login',
    pathMatch: 'full' //this property will check if there's a full match to the provided pattern in the URL and handle the page redirect from there using our desired redirection endpoint
    //ex. http://localhost:4200 -> auto sent to the login page
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

//This module's responsibility to manage and provide navigation routes for our Angular app
export class AppRoutingModule { }
