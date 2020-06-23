export class Menu { 
    
  level: number;
  title: string;
  url: string;
  icon: string;
  selected: boolean;
  disabled: boolean;
  constructor(level,title,url,icon,selected,disabled){
    this.level=level;
    this.icon=icon;
    this.title=title;
    this.selected=selected;
    this.disabled=disabled;
    this.url=url;

  }
}