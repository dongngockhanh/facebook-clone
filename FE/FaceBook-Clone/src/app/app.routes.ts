import { ChildActivationEnd, Routes } from '@angular/router';
import { LoginComponent } from './Components/login/login.component';
import { HomeComponent } from './Components/home/home.component';
import { authGuard } from './Services/Auth.Guard';
import { FriendPageComponent } from './Components/friend-page/friend-page.component';
import { ProfilePageComponent } from './Components/profile-page/profile-page.component';
import { ProfilePagePostsComponent } from './Components/profile-page/profile-page-posts/profile-page-posts.component';
import { ProfilePageAboutComponent } from './Components/profile-page/profile-page-about/profile-page-about.component';
import { ProfilePageFriendsComponent } from './Components/profile-page/profile-page-friends/profile-page-friends.component';
import { ProfilePagePhotosComponent } from './Components/profile-page/profile-page-photos/profile-page-photos.component';
import { ProfilePageVideosComponent } from './Components/profile-page/profile-page-videos/profile-page-videos.component';

export const routes: Routes = [
    // { path:'',redirectTo:'/login',pathMatch:'full'},
    { path:'',component:HomeComponent,canActivate:[authGuard]},
    { path:'login',component:LoginComponent},
    { path:'friends',component:FriendPageComponent},
    { path:'profile',component:ProfilePageComponent,children:[
        { path:'',component:ProfilePagePostsComponent},
        { path:'about',component:ProfilePageAboutComponent},
        { path:'friends',component:ProfilePageFriendsComponent},
        { path:'photos',component:ProfilePagePhotosComponent},
        { path:'videos',component:ProfilePageVideosComponent},
    ]}
];
