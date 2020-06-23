import { Injectable } from "@angular/core";
import { Headers, Http, Request, RequestOptions, Response, XHRBackend } from '@angular/http';
import { Router } from "@angular/router";
import { AppModule } from "../../../app.module";
import { Observable } from "rxjs";

/**
 * THis HTTP service extending Angular’s inbuilt http service 
 * so that we can control all the http calls going through the 
 * application at one place and can do some pre and post processing at one go.
 */
@Injectable()
export class HttpService extends Http {

    /* Some code come from http-helper.service */
    addContentTypeHeader: boolean | string = true;

    router: Router;

    constructor(backend: XHRBackend, options: RequestOptions) {
        super(backend, options);
        this.router = AppModule.injector.get(Router);
    }


    /**
     * Processing all the API requests inside request() method before making the actual API call. 
     * Also, this service gives us the ability to handle all API server errors at one place (catchError()). 
     * @param url 
     * @param options 
     */
    request(url: string | Request, options?: RequestOptions): Observable<Response> {
        if (typeof url === 'string') {
            if (!options) {
              // let's make an option object
              options = new RequestOptions({ headers: new Headers() });
            }
            this.createRequestOptions(options);
          } else {
            this.createRequestOptions(url);
          }
          return super.request(url, options);
    }


    createRequestOptions(options: RequestOptions | Request) {
        // get accesstokenLocalStorage
        const token: string = localStorage.getItem('accesstokenLocalStorage');

        // 
        if (this.addContentTypeHeader && typeof this.addContentTypeHeader === 'string') {
            options.headers.append('Content-Type', this.addContentTypeHeader);
        } else {
            const contentTypeHeader: string = options.headers.get('Content-Type');
            if (!contentTypeHeader && this.addContentTypeHeader) {
                options.headers.append('Content-Type', appVariables.defaultContentTypeHeader);
            }
            options.headers.append('Authorization', token);
        }
    }

    catchAuthError(self: HttpService) {
        // we have to pass HttpService's own instance here as `self`
        return (res: Response) => {
            if (res.status === 401 || res.status === 403) {
                // if not authenticated

            }
            return Observable.throw(res);
        };
    }
}

export const appVariables = {
    defaultContentTypeHeader: 'application/json'
}