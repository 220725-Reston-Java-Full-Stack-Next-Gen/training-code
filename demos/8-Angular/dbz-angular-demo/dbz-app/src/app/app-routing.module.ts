import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { CreateComponent } from './components/blogs/create/create.component';
import { ViewAllComponent } from './components/blogs/view-all/view-all.component';
import { BrowseComponent } from './components/browse/browse.component';
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
  //view all blogs endpoint to go to the ViewAllComponent
  {
    path: "blogs/view-all",
    component: ViewAllComponent
  },
  //create new blog enpoint to go to the CreateComponent
  {
    path: "blogs/create",
    component: CreateComponent
  },
  {
    path: "about",
    component: AboutComponent
  },
  {
    path: "browse",
    component: BrowseComponent
  },
  //for the browse endpoint, I also want the user to be able to extract their results from URL pattern when browse
  {
    //route params come in play here - you can define a param by using :param-name at any point of your path property
    path: "browse/:searchTerm",
    component: BrowseComponent
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
