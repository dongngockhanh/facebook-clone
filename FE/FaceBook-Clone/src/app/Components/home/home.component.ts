import { Component } from '@angular/core';
import { UserService } from '../../Services/User.service';
import { User } from '../../Dtos/User.Dto';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { UserResponse } from '../../Responses/User.response';
import { TestService } from '../../Services/test.service';
import { HeaderComponent } from "../header/header.component";
import { FormsModule } from '@angular/forms';
import { Post } from '../../Dtos/Post.Dto';
import { PostService } from '../../Services/Post.service';
import { PostResponse } from '../../Responses/Post.Response';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, HeaderComponent,FormsModule,RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
    constructor(private userService:UserService,private test:TestService,private postService:PostService){
      this.test.test();
      this.content="";
      this.post = new Post;
      this.getAllPost()
    }
    content!:string;
    post!:Post;
    keyWordSearch!:string;
    listPosts!:PostResponse[];
    getAllPost(){
      this.postService.getAllPost().subscribe({
        next: (response) => {
          this.listPosts = response;
        },
        error: (err) => {
          console.error(err);
        }
      })
    }

    create(){
      this.post.setContent(this.content);
      // this.post.setUserId(1);
      this.postService.createPost(this.post).subscribe({
        next: (respose) => {
          // this.listPosts.push(respose);
          this.content="";
          this.getAllPost();
        },
        error: (err) => {
          console.error(err);
        }
      })
    }
}
