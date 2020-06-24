
import { Injectable } from '@angular/core';
import { HttpCommonService } from '../_service/http-common.service';
import { environment } from '../../environments/environment';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';


@Injectable({
    providedIn: 'root'
})
export class CService {

    constructor(
        private httpCustomer: HttpCommonService,
        private http: HttpClient
    ) { }

    login(name: string, password: string) {
          return this.httpCustomer
            .httpPost(`${environment.apiUrl}/user-service/login/login`, {'name':name, 'password':password} )
            .pipe(
                map(
                    result => {
                        console.log(result+"in")
                        return result;
                    }
                )
            )
    }

    getMentor() {
        return this.httpCustomer
          .httpGet(`${environment.apiUrl}/user-service/fun/mentors`)
          .pipe(
              map(
                  result => {
                      return result;
                  }
              )
          )
  }


    register(name: string, password: string, type: string) {
        return this.httpCustomer
          .httpPost(`${environment.apiUrl}/user-service/reg/`, {'name': name, 'password': password,'type': type} )
          .pipe(
              map(
                  result => {
                      console.log(result+"reg")
                
                      return result;
                  }
              )
          )
    }


    searchM(name: string, skill: string) {
        const params = new HttpParams().set("name",name).set("skill",skill);
        return this.httpCustomer
          .httpGet(`${environment.apiUrl}/user-service/fun/mentors/param`,{params} )
          .pipe(
              map(
                  result => {
                      console.log(result+"reg")
                
                      return result;
                  }
              )
          )
    }


    applyM(userID: string, mentorMail: string) {
        const params = new HttpParams().set("userID",userID).set("mentorMail",mentorMail);
        return this.httpCustomer
          .httpGet(`${environment.apiUrl}/user-service/fun/apply/mentor`,{params} )
          .pipe(
              map(
                  result => {
                      return result;
                  }
              )
          )
    }


    getTraining(id: string) {
        const params = new HttpParams().set("userID",id);
        return this.httpCustomer
          .httpGet(`${environment.apiUrl}/user-service/fun/trainings`,{params})
          .pipe(
              map(
                  result => {
                      return result;
                  }
              )
          )
  }

  confirm(id: string) {
    const params = new HttpParams().set("id",id);
    return this.httpCustomer
      .httpGet(`${environment.apiUrl}/user-service/fun/confirm`,{params})
      .pipe(
          map(
              result => {
                  return result;
              }
          )
      )
}

reject(id: string) {
    const params = new HttpParams().set("id",id);
    return this.httpCustomer
      .httpGet(`${environment.apiUrl}/user-service/fun/reject`,{params})
      .pipe(
          map(
              result => {
                  return result;
              }
          )
      )
}
}