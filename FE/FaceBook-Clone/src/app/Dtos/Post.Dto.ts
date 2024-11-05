export class Post{
    private user_id: number;
    private content:String;
    constructor(){
        this.user_id = 0;
        this.content = "";
    }
    public setUserId(user_id:number){
        this.user_id = user_id;
    }
    public setContent(content: string){
        this.content = content;
    }
}