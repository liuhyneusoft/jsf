import { Component,OnInit } from '@angular/core';
import {video} from './../../model/video'

@Component({
  selector: 'app-my-video',
  templateUrl: './my-video.component.html',
  styleUrls: ['./my-video.component.css']
})
export class MyvideoComponent implements OnInit {

  currentPlayvideoID: any;
  playList: video[];
  currentPlayvideo: video;
  v2: video;
  v3: video;

  constructor(  ) {}

  ngOnInit(): void { 
   

    //this.v2 =  new video(0,"video","assets/video/video2.mp4",0,0,0);
    //this.v3 =  new video(0,"video","assets/video/video3.mp4",0,0,0);
    
  }

}
