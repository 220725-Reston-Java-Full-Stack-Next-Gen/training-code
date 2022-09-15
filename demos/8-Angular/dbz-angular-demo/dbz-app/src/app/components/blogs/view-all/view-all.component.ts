import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Blog } from 'src/app/models/blog';
import { BlogService } from 'src/app/services/blog.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrls: ['./view-all.component.css']
})
export class ViewAllComponent implements OnInit {
  blogs!: Blog[];
  newBlogs!: Blog[];
  //this is how you set a localVariable as an observable 
  public blog!: Observable<Blog>;
  activeId!: number;

  constructor(private changeDetect: ChangeDetectorRef, private service: BlogService, private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    console.log(localStorage.getItem("current-user") || "");
    this.service.getCurrentUser();
    this.getAllBlogs();
  }
  getAllBlogs() {
    //1. subscribe to the observable that returns from the service call
    this.service.getAllBlogs().subscribe(
      data => {
        // print result data
        console.log(`Backend data: ${data}`);

        //set the blogs array to the result data
        this.blogs = data;
        console.log("Blogs: " + this.blogs);

        //check for detectable changes in the HTML template
        this.changeDetect.detectChanges();
      }
    );

    //2. set the blogs array to equal the newBlogs array for proper reset for changeDetect
    this.blogs = this.newBlogs;
  }

}
