import { NzTableModule } from 'ng-zorro-antd/table';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { CService } from "../../_service/cservice";
import { NzMessageService } from 'ng-zorro-antd/message';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usertrain',
  templateUrl: './usertrain.component.html',
  styleUrls: ['./usertrain.component.css']
})
export class UsertrainComponent implements OnInit {

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
        debugger;
        this.listOfData = result.responseBody.result;
			}
		});
  }

}
