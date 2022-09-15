import { User } from "./user";

export class Blog{
    id: number;
    title: string;
    subject: string;
    body: string;
    categories: string;
    owner: User

    constructor(id: number, title: string, subject: string, body: string, categories: string, owner: User){
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.body = body;
        this.categories = categories;
        this.owner = owner
    }
}