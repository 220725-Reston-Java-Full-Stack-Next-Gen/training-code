import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Blog } from 'src/app/models/blog';
import { BlogService } from 'src/app/services/blog.service';

@Component({
  selector: 'app-browse',
  templateUrl: './browse.component.html',
  styleUrls: ['./browse.component.css']
})
export class BrowseComponent implements OnInit {

  blogs!: Blog[];
  newBlogs!: Blog[];
  public blog!: Observable<Blog>;

  constructor(private changeDetect: ChangeDetectorRef, private service: BlogService, private route: ActivatedRoute) { }

  public trackItem(index: number, item: Blog) {
    return `${item.id}-${index}`;
  }
  
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if(params.searchTerm){
        this.service.getAllBlogs().subscribe(blogs => {
          this.blogs = blogs.filter(blog => blog.title.toLowerCase().includes(params.searchTerm.toLowerCase()))
        })
      }else{
        this.service.getAllBlogs().subscribe(data => {
          console.log(data);
          this.blogs = data;
          console.log("TEST DATA: " + JSON.stringify(this.blogs));
        });
      }
    });
  }

}
