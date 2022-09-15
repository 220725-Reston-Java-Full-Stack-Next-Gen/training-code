import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Blog } from '../models/blog';
import { ClientMessage } from '../models/client-message';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class BlogService {
  blog$!: Blog;
  url: string = environment.APP_URL;

  constructor(private http: HttpClient) { }

  getCurrentUser(): void{
    let user = JSON.parse(localStorage.getItem("current-user"));
    console.log(user);
    this.http.get<User>(`${this.url}users/find-by-username?username=${user.username}`)
    .subscribe(data => {
          console.log(data);
      }
    );
  }

  createNewBlog(blog: Blog): void{
    console.log("creating a new blog with info: " + JSON.stringify(blog));
    
    let body = {
      title: blog.title,
      subject: blog.subject,
      body: blog.body,
      categories: blog.categories
    };
    console.log(`Body: ${JSON.stringify(body)}`);

    this.http.post<ClientMessage>(`${this.url}blogs/${blog.owner.id}`, JSON.stringify(body))
    .subscribe(data => {
          console.log(data);
        }
    );
  }

  getAllBlogs(){
    return this.http.get<Blog[]>(`${this.url}blogs/view-all`);
  }
}
