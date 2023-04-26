
import { iGroup } from "./iGroup";

export interface iContact {
    id ? : number;
    name ?: string;
    email ?: string;
    url ?: string;
    phoneNumber ?: string;
    company ?: string;
    title ?: string;
    contactGroup ?: iGroup;
}