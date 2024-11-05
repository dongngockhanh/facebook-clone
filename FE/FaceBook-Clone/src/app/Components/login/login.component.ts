import { Component, NgModule } from '@angular/core';
import { User } from '../../Dtos/User.Dto';
import { FormsModule, NgForm } from '@angular/forms';
import { NgClass } from '@angular/common';
import { UserService } from '../../Services/User.service';
import { HttpClientModule } from '@angular/common/http';
import { Router, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent{
    user!: User;
    email!: String;
    password!: String;
    constructor(private userService:UserService,private router:Router){
      this.email="";
      this.password="";
      this.user = new User;
    }
    clickLogin(){
      this.user.setEmail(this.email);
      this.user.setPassword(this.password);
      this.userService.login(this.user).subscribe({
        next:(response)=>{
          // console.log(response);
          this.userService.saveToken(response.token);
          this.router.navigate(['/']);
        },
        error: (err:any)=>{
          console.error("Đăng nhập thất bại",err);
        }
      });
    }
}
