import { iContact } from "./iContact";


export interface IUser {
    id ?: number;
    username ?: string;
    phoneNumber?: string;
    contacts ?: iContact[];

}
