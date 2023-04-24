import { DataServiceService } from './../../services/dataService.service';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { iContact } from 'src/app/models/iContact';

@Component({
  selector: 'app-view-contact',
  templateUrl: './view-contact.component.html',
  styleUrls: ['./view-contact.component.css']
})
export class ViewContactComponent implements OnInit{

  contact:iContact;

  contactId:number = 0;

  constructor(private data:DataServiceService,private route:ActivatedRoute){

    this.contactId=this.route.snapshot.params['contactId'];
    this.data.http.get(this.data.baseUrl+"contacts/getContact/"+this.contactId).subscribe(
      (response:iContact)=>{
        this.contact=response;
      }
    );

  }
  ngOnInit(): void {
    
    
  }
}
