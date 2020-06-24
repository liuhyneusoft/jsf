 
import { NzTableModule } from 'ng-zorro-antd/table';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { CService } from "../../_service/cservice";
import { NzMessageService } from 'ng-zorro-antd/message';
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-cuser',
  templateUrl: './cuser.component.html',
  styleUrls: ['./cuser.component.css']
})
export class CuserComponent implements OnInit {
  listOfData   = [];
  validateForm!: FormGroup;
  constructor(   private message: NzMessageService,
    private fb: FormBuilder,
    private prService: CService,
    private router: Router ) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      name: [null] ,
      skill: [null]
    });
    this.initTable();
  }
  selMent(mail):void {
    this.message.info("select mentor " + mail );
    this.message.info("select mentor id " + sessionStorage.getItem("userID") );
    this.prService.applyM(sessionStorage.getItem("userID"), mail) 
    .subscribe(result => {
      if (result.code != '00000') {
        this.message.error(result.msg);
				return;
			} else {
        this.message.info(result.msg);
			}
		});

  }

  initTable(): void { 
		this.prService.getMentor( )
    .subscribe(result => {
      if (result.code != '00000') {
        this.message.error(result.msg);
				return;
			} else {
        debugger;
        this.listOfData = result.responseBody.result;
			}
		});
  }
  searchM():void {
    this.prService.searchM(this.validateForm.value.name, 
      this.validateForm.value.skill)
    .subscribe(result => {
      if (result.code != '00000') {
        this.message.error(result.msg);
				return;
			} else {
        this.listOfData = result.responseBody.result;
			}
		});
  }
}
