import { Routes } from '@angular/router';
import { LoginComponent } from './Components/login/login.component';
import { HomeComponent } from './Components/home/home.component';
import { authGuard } from './Services/Auth.Guard';
import { FriendPageComponent } from './Components/friend-page/friend-page.component';
import { ProfilePageComponent } from './Components/profile-page/profile-page.component';

export const routes: Routes = [
    // { path:'',redirectTo:'/login',pathMatch:'full'},
    { path:'',component:HomeComponent,canActivate:[authGuard]},
    { path:'login',component:LoginComponent},
    { path:'friends',component:FriendPageComponent},
    { path:'profile',component:ProfilePageComponent}
];
