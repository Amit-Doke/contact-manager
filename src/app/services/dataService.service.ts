import { User } from './../entities/User';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { iContact } from '../models/iContact';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {


baseUrl:string="http://localhost:8080/";
user:User;
contacts:iContact[]=[];
constructor(public http:HttpClient) {

 }

}
