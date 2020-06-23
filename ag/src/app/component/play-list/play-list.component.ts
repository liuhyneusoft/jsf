import { Component, OnInit,ElementRef } from '@angular/core';
import { video } from './../../model/video';
import { videosService} from './../../core/videos.service';
import { Menu } from './../../model/menu';
@Component({
  selector: 'app-play-list',
  templateUrl: './play-list.component.html',
  styleUrls: ['./play-list.component.css']
})
export class PlayListComponent implements OnInit {

  constructor(
    private el: ElementRef,
    private videoService:videosService,
  ) { }

  ngOnInit(): void {
    this.getMenus();
  }
  getMenus(): void {
      
    this.videoService.getvideos().subscribe(videos => {
      let i = 0;
      for (let video of videos) {
        let disabled = true;
        if(video.status == 1) disabled = false;
 
        i++;
      }
    })
  }

  mode = false;
  dark = false;
  menus = [
   
    {
      level: 1,
      title: 'Login',
      url: '/clogin',
      icon: 'setting',
      selected: false,
      disabled: false
    },
    {
      level: 1,
      title: 'Sign UP',
      url: '/csignup',
      icon: 'setting',
      selected: false,
      disabled: false
    },
    {
      level: 1,
      title: 'User',
      url: '/cuser',
      icon: 'setting',
      selected: false,
      disabled: false
    },
    {
      level: 1,
      title: 'Mentor',
      url: '/cmentor',
      icon: 'setting',
      selected: false,
      disabled: false
    }
  ];

}
