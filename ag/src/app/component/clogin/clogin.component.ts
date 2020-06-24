 
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { CService } from "../../_service/cservice";
import { NzMessageService } from 'ng-zorro-antd/message';
import { Router } from '@angular/router';
@Component({
  selector: 'app-clogin',
  templateUrl: './clogin.component.html',
  styleUrls: ['./clogin.component.css']
})
export class CloginComponent implements OnInit {
  validateForm!: FormGroup;

  actionUrl = `${environment.apiUrl}/user-service/login/login?time=${new Date().getTime()}`;

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
  }

  constructor(
    private message: NzMessageService,
    private fb: FormBuilder,
    private prService: CService,
    private router: Router 
    ) {}
 

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      userName: [null, [Validators.required]],
      password: [null, [Validators.required]],
      remember: [true]
    });
  }

  login(): void { 
		this.prService.login(
      this.validateForm.value.userName, 
      this.validateForm.value.password)
    .subscribe(result => {
      
      if (result.code != '00000') {
        this.message.error(result.msg);
				return;
			} else {
        console.log(result.responseBody.token)
        this.message.info('welcome ' + result.responseBody.userName);
        this.router.navigateByUrl("/cuser");
			}
		});
  }

  regBtn():void {
    this.router.navigateByUrl("/csignup");
  }
  
  fgPw():void {
    this.message.info('developing' );
  }
  // validateForm!: FormGroup;
 

  // submitForm(): void {
  //   for (const i in this.validateForm.controls) {
  //     this.validateForm.controls[i].markAsDirty();
  //     this.validateForm.controls[i].updateValueAndValidity();
  //   }
  // }

  // constructor(private fb: FormBuilder) {}

  // ngOnInit(): void {
  //   this.validateForm = this.fb.group({
  //     userName: [null, [Validators.required]],
  //     password: [null, [Validators.required]],
  //     remember: [true]
  //   });
  // }

}
