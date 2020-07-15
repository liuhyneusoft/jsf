import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MyvideoComponent } from './component/my-video/my-video.component';
import { EditvideoComponent } from './component/edit-video/edit-video.component';
import { CloginComponent } from './component/clogin/clogin.component';
import { CsignupComponent } from './component/csignup/csignup.component';

import { CuserComponent } from './component/cuser/cuser.component';
import { CmentorComponent } from './component/cmentor/cmentor.component';
import { UsertrainComponent } from './component/usertrain/usertrain.component';
import { CpaymentComponent } from './component/cpayment/cpayment.component';
import { CskillComponent } from './component/cskill/cskill.component';
import { CnotificationComponent } from './component/cnotification/cnotification.component';

const routes: Routes = [
  
  { path: 'video/:id', component: MyvideoComponent},
  { path: 'edit', component: EditvideoComponent},
  { path: 'clogin', component: CloginComponent},
  { path: 'csignup', component: CsignupComponent},
  { path: 'cuser', component: CuserComponent},
  { path: 'cmentor', component: CmentorComponent},
  { path: 'cusertrain', component: UsertrainComponent},
  { path: 'cpayment', component: CpaymentComponent},
  { path: 'cskill', component: CskillComponent},
  { path: 'cnotification', component: CnotificationComponent},
  { path: '**', component: CloginComponent}
 
  
];

@NgModule({

  imports: [
      RouterModule.forRoot(
          routes,
          { enableTracing: true } // <-- debugging purposes only
        )
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
