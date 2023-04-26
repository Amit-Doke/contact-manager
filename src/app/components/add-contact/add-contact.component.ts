
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Contact } from 'src/app/entities/Contact';
import { Group } from 'src/app/entities/Group';
import { iGroup } from 'src/app/models/iGroup';
import { DataServiceService } from 'src/app/services/dataService.service';

@Component({
  selector: 'app-add-contact',
  templateUrl: './add-contact.component.html',
  styleUrls: ['./add-contact.component.css']
})
export class AddContactComponent 
{
  newContact:Contact=new Contact();       //for creating new contact
  groups:iGroup[]=[];    
  group:number;                     
  constructor( public data:DataServiceService,private route:Router)
  {
      data.http.get(data.baseUrl+"contacts/getGroup").subscribe(
        (response:iGroup[]) =>{
          this.groups=response;
        }
      );
  }


  addContact(){

    console.log(this.group);
    this.data.http.post(this.data.baseUrl+"contacts/createContact/"+this.data.user.id+"/"+this.group,this.newContact).subscribe(
      (response:boolean) =>{
        if (response) {
          window.alert("Contact Created And Successfully")
          this.route.navigate(["/"]);
        }
        else {
          let choice = window.confirm("Contact Not Created \n Do you want to continue");
          if (!choice) {
            this.route.navigate["/"];
          }
        }
      }
    );
  }
}
