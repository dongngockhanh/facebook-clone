import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { PostResponse } from "../Responses/Post.Response";
import { Post } from "../Dtos/Post.Dto";

@Injectable({
    providedIn:'root'
})
export class PostService{
    constructor(private http:HttpClient){}
    private postUrl = "http://localhost:8080/posts";
    
    public getAllPost():Observable<PostResponse[]>{
        return this.http.get<PostResponse[]>(this.postUrl);
    }

    public createPost(post:Post):Observable<PostResponse>{
        const headers = new HttpHeaders({
            'Content-Type': 'application/json' // Thiết lập Content-Type
          });
        return this.http.post<PostResponse>(this.postUrl+"/create",post,{headers});
    }
}