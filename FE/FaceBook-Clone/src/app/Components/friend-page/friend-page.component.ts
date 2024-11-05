import { Component } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-friend-page',
  standalone: true,
  imports: [HeaderComponent,FormsModule,CommonModule],
  templateUrl: './friend-page.component.html',
  styleUrl: './friend-page.component.scss'
})
export class FriendPageComponent {
  // friendRequests:any[]= new Array(5).fill(null); // Khởi tạo mảng với 5 phần tử có giá trị `null`
  friends: any[] = new Array(5).fill(null); // Khởi tạo mảng với 5 phần tử có giá trị `null`
  friendRequests:any[] =new Array(5).fill(null);
  // selectedOption="friends"
  selectedOption="requests"
  selectOption(request:string){
    this.selectedOption=request;
  }
  acceptRequest(request:string){

  }
  declineRequest(request:string){

  }
}
