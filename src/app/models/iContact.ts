import { Group } from "../entities/Group";

export interface iContact {
    id ? : number;
    name ?: string;
    email ?: string;
    url ?: string;
    phoneNumber ?: string;
    company ?: string;
    title ?: string;
    contactGroup ?: Group;
}