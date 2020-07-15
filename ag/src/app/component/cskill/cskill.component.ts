 
import { NzTableModule } from 'ng-zorro-antd/table';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { CService } from "../../_service/cservice";
import { NzMessageService } from 'ng-zorro-antd/message';
import { Router } from '@angular/router';
@Component({
  selector: 'app-cskill',
  templateUrl: './cskill.component.html',
  styleUrls: ['./cskill.component.css']
})
export class CskillComponent implements OnInit {
  validateForm!: FormGroup;
  isVisible = false;
 
  listOfData   = [];
  constructor( private message: NzMessageService,
    private fb: FormBuilder,
    private prService: CService,
    private router: Router ) { }

  ngOnInit(): void {
    this.initTable();
    this.validateForm = this.fb.group({
      skillName: [null, [Validators.required]]  ,
      skillID : [null]
    });
  }
  showModal(): void {
    this.isVisible = true;
   
  }
  modify(id, name):void {
    this.isVisible = true;
    this.validateForm = this.fb.group({
      skillName: [name],
      skillID : [id]
    });

  }
  handleOk(): void {
    console.log('Button ok clicked!');
    this.prService.addSkill(this.validateForm.value.skillID, this.validateForm.value.skillName)
    .subscribe(result => {
      if (result.code != '00000') {
        this.message.error(result.msg);
				return;
			} else {
        this.message.info(' success');
        this.initTable();
			}
		});
    this.isVisible = false;
  }

  handleCancel(): void {
    console.log('Button cancel clicked!');
    this.isVisible = false;
  }

  
  initTable(): void { 
		this.prService.getSkill()
    .subscribe(result => {
      if (result.code != '00000') {
        this.message.error(result.msg);
				return;
			} else {
      
        this.listOfData = result.responseBody.result;
			}
		});
  }



 

  delete(id):void {
     
    this.prService.delSkill(id) 
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
