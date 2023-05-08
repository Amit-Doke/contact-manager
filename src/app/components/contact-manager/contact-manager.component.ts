import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { iContact } from 'src/app/models/iContact';
import { DataServiceService } from 'src/app/services/dataService.service';


@Component({
  selector: 'app-contact-manager',
  templateUrl: './contact-manager.component.html',
  styleUrls: ['./contact-manager.component.css']
})
export class ContactManagerComponent implements OnInit {

 

  contacts:iContact[] = [];


  constructor(public data:DataServiceService) {}

  ngOnInit(): void {
   
      this.data.http.get(this.data.baseUrl+"contacts/getContacts/"+1).subscribe(
        (response:iContact[]) => {
          this.data.contacts=response;
          this.data.user.contacts=response;
          this.contacts=response;
        }
      );  

    }

    deleteContact(id:number){

      this.data.http.delete(this.data.baseUrl+"contacts/"+this.data.user.id+"/"+id).subscribe(
        (response:boolean)=>{
          if (response) {
            window.alert("Contact deleted Successfully");
            let i=this.contacts.findIndex(temp=>temp.id==id);
            this.contacts.splice(i,1);
          }
          else {
            window.alert("Contact Not Deleted successfully");
          }
        }
      );

    }
  }
  

