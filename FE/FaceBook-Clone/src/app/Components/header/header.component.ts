import { Component } from '@angular/core';
import { UserService } from '../../Services/User.service';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { UserResponse } from '../../Responses/User.response';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterLink,RouterLinkActive,RouterOutlet],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  constructor(private userService:UserService){
    this.keyWordSearch="";
  }

  keyWordSearch!:string;
  listUserFind:UserResponse[]=[];

  logout(){
    this.userService.logout();
    window.location.reload();
  }
  searchUser(){
    this.userService.findUser(this.keyWordSearch).subscribe({
      next: (reponse) => {
        this.listUserFind = reponse;
        console.log(this.listUserFind);
      },
      error: (err) => {
        console.error(err);
      }
    })
  }
  clearInput() {
    this.keyWordSearch = ""; // Xóa nội dung ô nhập
    this.listUserFind = []; // Xóa danh sách kết quả
  }
}
