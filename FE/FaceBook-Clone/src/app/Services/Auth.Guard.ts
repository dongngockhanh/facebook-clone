import { inject } from "@angular/core";
import { CanActivateFn, Router } from "@angular/router";
import { AuthService } from "./Auth.service";

export const authGuard:CanActivateFn = () =>{
    const authService = inject(AuthService);
    const router = inject(Router);
    if(authService.isloggedIn()){
        return true;
    }else{
        router.navigate(['/login']);
        return false;
    }
}