import { Component, OnInit  } from '@angular/core';
import {video} from './../../model/video'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import{ videosService } from './../../core/videos.service'


@Component({
  selector: 'app-edit-video',
  templateUrl: './edit-video.component.html',
  styleUrls: ['./edit-video.component.css']
})
export class EditvideoComponent implements OnInit {

  playList = [];
  
  isVisible = false;
  isConfirmLoading = false;

  constructor( 
    private fb: FormBuilder,
    private videosService: videosService) { }

  ngOnInit(): void {
    
    this.getPlayList();
    this.initValidateForm(); 
  }
  getPlayList(){
    debugger
      let a = { id: 2,
              title: "video2",  
              url: "assets/video/video2.mp4", 
              status: 0,
              like: 0,
              unLike: 0};
      let b ={ id: 3,
              title: "video3",  
              url: "assets/video/video3.mp4", 
              status: 0,
              like: 0,
              unLike: 0};
      this.playList.push(a);
      this.playList.push(b);
  }
  initValidateForm(){
    this.validateForm = this.fb.group({
      title: [null, [Validators.required]],
      url: [null, [Validators.required]],
      remember: [true]
    });
  }

  startEdit(id: string): void {
    this.playList.forEach(item => {
      if(item.id == id ){
        alert("edit " + item.title);
      }
    });
  }

  Approve(id: number): void {
    this.playList.forEach(item => {
      if(item.id == id ){
        alert("approve " + item.title);
      }
    });
  }
  playListtmp = [];
  delete(id: number): void {
    
    this.playList.forEach(item => {
      if(item.id == id ){
        alert("delete " + item.title);
      } else {
        this.playListtmp.push(item);
      }
    });
    this.playList = this.playListtmp;
  }
  
  showModal(): void {
    this.isVisible = true;
  }

  addvideo(): void {
    const li = this.playList;
    this.playList = [];
      let a = { 
        id: Number((Math.random() * 100).toFixed(0)),
        title:  this.validateForm.value.title,  
        url: this.validateForm.value.url,
        status: 0,
        like: 0,
        unLike: 0
      };
      li.push(a);
      this.playList = li;
        debugger;
        this.isVisible = false;
  }

  handleCancel(): void {
    this.isVisible = false;
  }

  validateForm: FormGroup;

  submitForm(): void {
    
  }

}


