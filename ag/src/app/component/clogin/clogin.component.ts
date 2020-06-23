 
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-clogin',
  templateUrl: './clogin.component.html',
  styleUrls: ['./clogin.component.css']
})
export class CloginComponent implements OnInit {
  validateForm!: FormGroup;
   
  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
  }

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      userName: [null, [Validators.required]],
      password: [null, [Validators.required]],
      remember: [true]
    });
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
