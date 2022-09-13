export class User{
    //just like in java, we need to declare our class fields
    id: number;
    username: string;
    password: string;
    firstname: string;
    lastname: string;
    email: string;

    constructor(id: number, uname: string, pw: string, fname: string, lname: string, email: string){
        this.id = id;
        this.username = uname;
        this.password = pw;
        this.firstname = fname;
        this.lastname = lname;
        this.email = email;
    }
}