export class User{
    private email:String;
    private password:String;
    constructor(){
        this.email = "";
        this.password = "";
    }
    public getEmail(){
        return this.email;
    }
    public getPassword(){
        return this.password;
    }
    public setEmail(email:String){
        this.email = email;
    }
    public setPassword(password:String){
        this.password = password;
    }
}