import { Injectable } from "@angular/core";
import { TestService } from "./test.service";
import { Observable } from "rxjs";

@Injectable({
    providedIn:'root'
})
export class AuthService{
    constructor(private test:TestService){}
    isloggedIn():boolean{
        return !!localStorage.getItem('token');
    }
}