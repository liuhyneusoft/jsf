import { Injectable } from '@angular/core';
import { HttpClient, HttpParams,HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { video } from './../model/video';
import { HttpErrorHandler, HandleError } from './../core/http-error-handler.service';
import { HttpService } from './http.service';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable()
export class videosService {
  videosUrl = "http://localhost:4200/video";  // URL to web api
  private handleError: HandleError;

  constructor(
    private http: HttpService,
    httpErrorHandler: HttpErrorHandler) {
    this.handleError = httpErrorHandler.createHandleError('videoesService');
  }

  /** GET heroes from the server */
  getvideos (): Observable<video[]> {
    return this.http.get(this.videosUrl) as Observable<video[]> ;
  }
  searchvideo(id: number): Observable<video> {
    const url = this.videosUrl+"/"+id;
    console.log("url:"+url)
    return  this.http.get(url);
  }
  /** POST: add a new hero to the database */
  addvideo (video: video): Observable<video> {
    return this.http.post(this.videosUrl, video) as Observable<video> ;
  }

  /** DELETE: delete the hero from the server */
  deletevideo (id: number): Observable<{}> {
    const url = `${this.videosUrl}/${id}`; // DELETE api/heroes/42
    return this.http.delete(url);
  }

  /** PUT: update the hero on the server. Returns the updated hero upon success. */
  updatevideo (video: video): Observable<video> {
    console.log("id"+video.id+"like:"+video.like+"unlike:"+video.unLike)
    return this.http.put(this.videosUrl+"/"+video.id, video) as Observable<video>;
  }
}
