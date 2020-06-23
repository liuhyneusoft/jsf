import { Injectable } from '@angular/core'
import { HttpHeaders, HttpErrorResponse, HttpClient } from '@angular/common/http';
import { Observable, throwError  } from 'rxjs';
import { map, catchError   } from 'rxjs/operators';



const httpOptions = {
    headers : new HttpHeaders({'Content-Type':'application/json'})
}

@Injectable({
    providedIn :'root'
})
export class HttpService{

    constructor(
        private http: HttpClient
    ){ }

    public get(url:string ): Observable<any>{

        return this.http.get(url , httpOptions).pipe(
            map(this.extractData),
            catchError(this.handleError)
        );      
        
    }

    public post(url: string, data={}): Observable<any>{

        return this.http.post(url,data,httpOptions).pipe(
            map(this.extractData),
            catchError(this.handleError)
        )
    }


    public put (url: string , data = {}): Observable<any>{

        return this.http.put(url,data,httpOptions).pipe(
            map(this.extractData),
            catchError(this.handleError)
        )
    }

    public delete(url: string): Observable<any>{

        return this.http.delete(url,httpOptions).pipe(
            map(this.extractData),
            catchError(this.handleError)
        )
    }

    private extractData(res: Response){
        let body = res;
        return body || {};
    }

    private handleError(error: HttpErrorResponse){
        if(error.error instanceof ErrorEvent)
            console.error('An eror occurren',error.error.message);
        else 
            console.error('Rentrued code '+error.status, 'body was:'+error.error);
        return throwError('Something bad happened ; please try again later.');
    }
}