import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { User } from "../Dtos/User.Dto";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginResponse } from "../Responses/Login.Response";
import { __param } from "tslib";
import { UserResponse } from "../Responses/User.response";

@Injectable(
    {providedIn:'root'}
)
export class UserService{
    private urlUser = "http://localhost:8080/users";
    constructor(private http:HttpClient){
    }

    public login(user:User):Observable<LoginResponse>{
        const jsonString = JSON.stringify(user);
        const headers = new HttpHeaders({
            'Content-Type': 'application/json' // Thiết lập Content-Type
          });
        return this.http.post<LoginResponse>(this.urlUser+"/login",jsonString, {headers});
    }
    public logout(){
        this.remoteToken();
    }
    public findUser(keyWord:string):Observable<UserResponse[]>{
        const params = new HttpParams().set("name",keyWord);
        return this.http.get<UserResponse[]>(this.urlUser+"/search",{params});
    }
    public remoteToken(){
        localStorage.removeItem('token');
    }
    public saveToken(token:string){
        localStorage.setItem("token",token);
    }
}