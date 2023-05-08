import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Contact } from 'src/app/entities/Contact';
import { iGroup } from 'src/app/models/iGroup';
import { DataServiceService } from 'src/app/services/dataService.service';

@Component({
  selector: 'app-edit-contact',
  templateUrl: './edit-contact.component.html',
  styleUrls: ['./edit-contact.component.css']
})
export class EditContactComponent {
  //TODO: same as addContact
  newContact:Contact=new Contact();       //for creating new contact
  groups:iGroup[]=[];    
  group:number;        
  contactId:number;             
  constructor( public data:DataServiceService,private route:Router,private activeRoute:ActivatedRoute)
  {
      data.http.get(data.baseUrl+"contacts/getGroup").subscribe(
        (response:iGroup[]) =>{
          this.groups=response;
        }
      );

      this.contactId=this.activeRoute.snapshot.params['contactId'];
  }

  editContact()
  {
    this.newContact.id=this.contactId;
    this.data.http.put(this.data.baseUrl+"contacts/updateContact/"+this.data.user.id+"/"+this.group,this.newContact).subscribe(
      (response:boolean) =>{
        if (response) {
          window.alert("Contact Updated Successfully")
          this.route.navigate(["/"]);
        }
        else {
          let choice = window.confirm("Contact Not updated \n Do you want to continue");
          if (!choice) {
            this.route.navigate["/"];
          }
        }
      }
    );
  }
}
