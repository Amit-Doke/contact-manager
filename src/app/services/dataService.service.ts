import { User } from './../entities/User';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { iContact } from '../models/iContact';
import { IUser } from '../models/iUser';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {


baseUrl:string="http://localhost:8080/";
user:IUser={
  "id":1,
  "username":"amit",
  "phoneNumber":"123456",
  "contacts":[]
};
contacts:iContact[]=[];
constructor(public http:HttpClient) {

 }

}
