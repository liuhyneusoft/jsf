import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ControlComponent } from './component/control/control.component';
import { PlayListComponent } from './component/play-list/play-list.component';
import { MyvideoComponent } from './component/my-video/my-video.component';
import { EditvideoComponent } from './component/edit-video/edit-video.component';

import { FormsModule,ReactiveFormsModule }  from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientXsrfModule } from '@angular/common/http';

import { NgZorroAntdModule  } from 'ng-zorro-antd';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { videosService } from './core/videos.service'
import { HttpService } from './core/http.service';
import { HttpErrorHandler} from './core/http-error-handler.service';
import { MessageService} from './core/message.service';
import { CloginComponent } from './component/clogin/clogin.component';
import { CsignupComponent } from './component/csignup/csignup.component';
import { CuserComponent } from './component/cuser/cuser.component';
import { CmentorComponent } from './component/cmentor/cmentor.component';
import { UsertrainComponent } from './component/usertrain/usertrain.component';
import { CpaymentComponent } from './component/cpayment/cpayment.component'
@NgModule({
  declarations: [
    AppComponent,
    ControlComponent,
    PlayListComponent,
    MyvideoComponent,
    EditvideoComponent,
    CloginComponent,
    CsignupComponent,
    CuserComponent,
    CmentorComponent,
    UsertrainComponent,
    CpaymentComponent
  ],
  imports: [
    ReactiveFormsModule,
    BrowserAnimationsModule,
    NgZorroAntdModule ,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: 'My-Xsrf-Cookie',
      headerName: 'My-Xsrf-Header',
    }),
    AppRoutingModule
  ],
  providers: [videosService,HttpService,HttpErrorHandler,MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
