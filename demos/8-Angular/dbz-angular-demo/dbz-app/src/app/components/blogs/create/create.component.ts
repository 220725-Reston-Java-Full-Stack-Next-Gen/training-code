import { Component, OnInit } from '@angular/core';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';
import { Blog } from 'src/app/models/blog';
import { User } from 'src/app/models/user';
import { BlogService } from 'src/app/services/blog.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  value: string | null = localStorage.getItem("user-info");
  blog: Blog = new Blog(0, "", "", "", "", new User(0, "", "", "", "", ""));

  constructor(public modalRef: MdbModalRef<CreateComponent>, private service: BlogService) { }

  ngOnInit(): void {
    this.service.getCurrentUser();
  }

  createPost(event: any){
    console.log(this.blog);

    if(this.blog.title !== "" &&
        this.blog.subject !== "" && 
        this.blog.body !== "" && 
        this.blog.categories !== ""
      )
    {
      //set owner info to new post
      this.blog.owner = JSON.parse(localStorage.getItem('user-info') || '{}');
      console.log(this.blog.owner);
      this.service.createNewBlog(this.blog);
      this.modalRef.close();
    }else{
      throw new Error("Empty fields in form!");
    }
  }

}
