import { HttpEvent, HttpHandler, HttpHandlerFn, HttpInterceptor, HttpInterceptorFn, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
//đính token lên header
export const authInterceptor:HttpInterceptorFn = (req:HttpRequest<any>, next: HttpHandlerFn): Observable<any> =>{
    const token = localStorage.getItem('token');
    if(token){
        const clonedRequest = req.clone({
            headers: req.headers.set('Authorization',`Bearer ${token}`)
        });
        return next(clonedRequest);
    }
    return next(req);
}
