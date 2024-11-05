import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, map, Observable, of } from "rxjs";

@Injectable({
    providedIn:'root'
})
export class TestService{
    constructor(private http:HttpClient){}
    test(){
        this.http.get("http://localhost:8080").subscribe(
            message => {
                console.log(message);
            }
        )
    }
    
    testLogin(): boolean {
        return true;
    }
    
}