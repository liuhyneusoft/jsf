 
import { NzTableModule } from 'ng-zorro-antd/table';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { CService } from "../../_service/cservice";
import { NzMessageService } from 'ng-zorro-antd/message';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cmentor',
  templateUrl: './cmentor.component.html',
  styleUrls: ['./cmentor.component.css']
})
export class CmentorComponent implements OnInit {
  listOfData   = [];
  constructor( private message: NzMessageService,
    private fb: FormBuilder,
    private prService: CService,
    private router: Router ) { }

  ngOnInit(): void {
    this.initTable();
  }

  initTable(): void { 
		this.prService.getTraining(sessionStorage.getItem("userID"))
    .subscribe(result => {
      if (result.code != '00000') {
        this.message.error(result.msg);
				return;
			} else {
       
        this.listOfData = result.responseBody.result;
			}
		});
  }


  confirm(id):void {
     
    this.prService.confirm(id) 
    .subscribe(result => {
      if (result.code != '00000') {
        this.message.error(result.msg);
				return;
			} else {
        this.initTable();
        this.message.info(result.msg);
			}
		});

  }


  reject(id):void {
     
    this.prService.reject(id) 
    .subscribe(result => {
      if (result.code != '00000') {
        this.message.error(result.msg);
				return;
			} else {
        this.initTable();
        this.message.info(result.msg);
			}
		});

  }



}
