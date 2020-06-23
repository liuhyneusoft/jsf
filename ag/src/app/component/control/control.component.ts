import { Component, OnInit, Renderer2, ElementRef } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute,Router,NavigationEnd } from '@angular/router';
import { video } from './../../model/video';
import { videosService} from './../../core/videos.service'
@Component({
  selector: 'app-control',
  templateUrl: './control.component.html',
  styleUrls: ['./control.component.css']
})
export class ControlComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private videoService:videosService,
    private router: Router,
    private el: ElementRef) { }

  ngOnInit(): void {
    this.initBaseData();
    this.getCurrentPlayvideo();
    this.currentPlayvideo= new video(0,"video","assets/video/video1.mp4",0,0,0);
  }
  ngAfterViewInit(){ 
    this.rounterListener();
  }
  
  rounterListener(){
    // 监听路由变化     
    this.router.events.subscribe((event:NavigationEnd) => {
      this.initBaseData();
      this.getCurrentPlayvideo();
      
    });
  }
  getCurrentPlayvideo(){
    this.route.paramMap.subscribe(params => {
      this.videoService.searchvideo(Number(params.get('id'))).subscribe(data => {
        this.videoDom.load();
        this.currentPlayvideo=data;
      });
     });
  }

  initBaseData(){
    this.videoDom = this.el.nativeElement.querySelector("video");
    this.videoPaused = true;   
    this.playPauseColor = "spanGreenColor" ;
    this.playPauseIcon="fa fa-play fa-2x";
    this.mutedIcon = "fa fa-headphones fa-2x i-item";
    this.muteColor="spanBlackColor";
    this.videoDom.volume= 0.5;
    this.volumeNum = this.videoDom.volume*10;
    this.videoCurrentTime = this.initTimeLength(this.videoDom.currentTime);
    this.videoDuration = "00:00";    
  }
  /**
   * ontimeupdate 当前视频播放位置反生改变触发的事件;
   */
  timeupdata(){
    // 视频时长
    let durationProgress=this.videoDom.duration;
    // currentTime 当前播放时长
    let currentTimeProgress=this.videoDom.currentTime;
    // 将当前播放时长填入左边时长元素中
    this.videoCurrentTime = this.initTimeLength(this.videoDom.currentTime);
    // 求当前播放时长的进度，从而显示出来进度条
    this.setCurrentProgressWidth(currentTimeProgress, durationProgress);
  }

  /**
   * loadedmetadata 事件 当指定的音频/视频的元数据已加载时，会发生 loadedmetadata 事件。
   */
  loadedmetadata(){
    this.videoDuration = this.initTimeLength(this.videoDom.duration);
  }

  /**
   * 集赞
   * @param like 
   */
  likeHendle(like){

    if(like == "like") this.currentPlayvideo.like ++;
    else this.currentPlayvideo.unLike ++;
    this.videoService.updatevideo(this.currentPlayvideo).subscribe(res => {
      this.currentPlayvideo = res
    });
  }

  /**
   * 设置音量
   * @param direction 
   */
  changeVolume(direction) {
    if (direction === '+') this.videoDom.volume += this.videoDom.volume == 1 ? 0 : 0.1;
    else this.videoDom.volume -= (this.videoDom.volume == 0 ? 0 : 0.1);
    this.videoDom.volume = parseFloat(this.videoDom.volume).toFixed(1);
    this.volumeNum= this.videoDom.volume*10;
  
  }

  /**
   * 静音
   */
  mutedHandle() {
    //如果为静音则开启，如果为开启状态则关闭
    this.videoDom.muted=!this.videoDom.muted;
    if (this.videoDom.muted) { // 禁音状态
      if (this.mutedIcon) {
        //通过操作不同的class，来切换键的形态
        this.mutedIcon = "fa fa-headphones  fa-2x i-item"
        this.muteColor="spanGreyColor ";
      }
    } else { // 开启状态
      if (this.mutedIcon) {
        //通过操作不同的class，来切换键的形态
        this.mutedIcon = "fa fa-headphones  fa-2x i-item"
        this.muteColor="spanBlackColor";
      }
    }
  }

  /**
   * 重播
   */
  replay(){
    this.videoDom.load();
    this.videoPaused = true;
    this.playPauseIcon ="fa fa-play  fa-2x";
    this.playPauseColor = "spanRedColor" ;
    this.playPauseColor = "spanGreenColor"
  }

  /**
   * 播放/暂停功能
   **/
  playPauseHandle() { // 播放暂停    
   // this.videoDom.play();
   if(this.videoPaused){
    this.videoDom.play();
    this.videoPaused = false;
    this.playPauseIcon ="fa fa-stop fa-2x"
    this.playPauseColor = "spanRedColor"
   }else{
    this.videoDom.pause();
    this.videoPaused = true;
    this.playPauseIcon = "fa fa-play fa-2x"
    this.playPauseColor = "spanGreenColor"
   }  
  }

  /**
   * 设置当前播放长度的进度条
   * @param currentTimeProgress 
   * @param durationProgress 
   */
  private setCurrentProgressWidth(currentTimeProgress, durationProgress){

    let currentWidth=100*(currentTimeProgress/durationProgress);
      const drawBar = this.el.nativeElement.querySelector("#drawBar");
      //console.log("drawBar:"+drawBar)
      const durationBar = this.el.nativeElement.querySelector("#durationBar");
      const currentBar = this.el.nativeElement.querySelector("#currentBar");
     // console.log("currentBar-width:"+currentBar.style.width);
      let currentLeft=currentWidth-((drawBar.offsetWidth/2)/durationBar.offsetWidth*100);
      currentBar.style.width = currentWidth > 0 ? currentWidth.toFixed(1)+'%' : '0px';
      drawBar.style.left = currentLeft > 0 ? currentLeft.toFixed(1)+'%': '0px';
  }

  private initTimeLength(timeLength) { // 根据秒数格式化时间
    timeLength = parseInt(timeLength);
    let second = timeLength % 60;
    let minute = (timeLength - second) / 60;
    return (minute<10?"0"+minute:minute)+":"+(second<10?"0"+second:second);
  };

  
  videoDom: any; // 播放器对象
  playPauseColor: any; // 
  playPauseIcon: any; // 播放/暂停图标对象
  videoPaused :boolean;
  mutedIcon: any; // 音量图标对象
  muteColor: any;
  volumeNum: any;
  videoCurrentTime: any;
  videoDuration: any;
  videoID: any;
  playList: video[];
  currentPlayvideo: video;

}
