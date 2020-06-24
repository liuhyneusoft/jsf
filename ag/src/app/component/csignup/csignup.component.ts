import { NzRadioModule } from 'ng-zorro-antd/radio';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CService } from "../../_service/cservice";
import { NzMessageService } from 'ng-zorro-antd/message';
import { Router } from '@angular/router';
@Component({
  selector: 'app-csignup',
  templateUrl: './csignup.component.html',
  styleUrls: ['./csignup.component.css']
})
export class CsignupComponent implements OnInit {
  validateForm!: FormGroup;
  //radioValue:'user';

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
  }
  changeRadio(){
   // debugger;
    //console.log("radioValue:" + this.radioValue)
  }
  updateConfirmValidator(): void {
    /** wait for refresh value */
    Promise.resolve().then(() => this.validateForm.controls.checkPassword.updateValueAndValidity());
  }

  confirmationValidator = (control: FormControl): { [s: string]: boolean } => {
    if (!control.value) {
      return { required: true };
    } else if (control.value !== this.validateForm.controls.password.value) {
      return { confirm: true, error: true };
    }
    return {};
  };
 

  constructor(
    private message: NzMessageService,
    private fb: FormBuilder,
    private prService: CService,
    private router: Router 
  ) {

  }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      email: [null, [Validators.email, Validators.required]],
      password: [null, [Validators.required]],
      checkPassword: [null, [Validators.required, this.confirmationValidator]],
      nickname: [null, [Validators.required]],
      phoneNumberPrefix: ['+86'],
      phoneNumber: [null, [Validators.required]],
      website: [null, [Validators.required]],
      agree: [false] ,
      radioValue:['user']
    });
  }


  regsiter(): void {
    //debugger
    this.prService.register(this.validateForm.value.email, 
      this.validateForm.value.password, 
      this.validateForm.value.radioValue)
    .subscribe(result => {
      if (result.code != '00000') {
        this.message.error(result.msg);
				return;
			} else {
        this.message.info('register success');
        this.router.navigateByUrl("/clogin");
			}
		});
  }

}
