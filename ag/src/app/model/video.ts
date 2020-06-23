export class video { 
  id: number;
  title: string;  
  url: string; 
  status: number;
  like: number;
  unLike: number;
  constructor(id,title,url,status,like,unLike){
    this.id=id;
    this.like=like;
    this.title=title;
    this.status=status;
    this.unLike=unLike;
    this.url=url;

  }
}