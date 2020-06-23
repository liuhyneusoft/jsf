import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { HandleError, HttpErrorHandleService } from './http-error-handle.service';
import { PlatformLocation} from '@angular/common';
import { Router} from '@angular/router';
import { environment } from "src/environments/environment";
@Injectable({
  providedIn: 'root'
})
export class HttpCommonService {
  private handleError: HandleError;
  
  constructor(private http: HttpClient,  private errorhandleservice: HttpErrorHandleService, private location: PlatformLocation, private routers: Router) {
    this.handleError = errorhandleservice.createHandleError();
  }
  locationUrl: any;

  httpGet(uri,params?):  Observable<any>{
    // console.log(this.location) //获取浏览器地址
    for (const i in this.location) {
      if ( i === 'location') { 
        this.locationUrl = this.location[i].origin;
        break; 
      } 
    }  //本地注掉

    // uri = this.locationUrl + environment.jumpUrl + uri; //QA
    // console.log(uri)
    if(params == null){
      return this.http.get(uri)
      .pipe(
        catchError(this.handleError('httpGet===>' + uri))
        );
      }else{
 
      return this.http.get(uri,params)
      .pipe(
        catchError(this.handleError('httpGet===>' + uri))
      );
    }
    
  }

  httpPost(uri,params): Observable<any> {
    for (const i in this.location) {
      if ( i === 'location') { 
      this.locationUrl = this.location[i].origin;
      break; 
      } 
      }
      
      console.log(params)
      console.log(uri)
    //  uri = this.locationUrl + environment.jumpUrl + uri;
    return this.http.post<any>(uri, params)
      .pipe(
        catchError(this.handleError('httpPost===>' + uri))
      );
  }

  httpDelete(uri,params): Observable<any> {
    for (const i in this.location) {
      if ( i === 'location') { 
      this.locationUrl = this.location[i].origin;
      break; 
      } 
      }
      console.log(this.locationUrl)
      // uri = this.locationUrl + environment.jumpUrl + uri;
      if(params == null){
        return this.http.delete(uri)
          .pipe(
            catchError(this.handleError('httpDelete===>' + uri))
          );
      }else{
        return this.http.delete(uri,params)
        .pipe(
          catchError(this.handleError('httpDelete===>' + uri))
        );
      }
  }
  
  httpPut(uri,params): Observable<any> {
    for (const i in this.location) {
      if ( i === 'location') { 
      this.locationUrl = this.location[i].origin;
      break; 
      } 
      }
      console.log(this.locationUrl)
     // uri = this.locationUrl + environment.jumpUrl + uri;
    return this.http.put<any>(uri, params)
      .pipe(
        catchError(this.handleError('httpPut===>' + uri))
      );
  }

}
