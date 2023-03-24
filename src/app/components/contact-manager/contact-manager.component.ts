import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { iContact } from 'src/app/models/iContact';
import { ContactService } from 'src/app/services/contact.service';

@Component({
  selector: 'app-contact-manager',
  templateUrl: './contact-manager.component.html',
  styleUrls: ['./contact-manager.component.css']
})
export class ContactManagerComponent implements OnInit {

  public loading:boolean=false;
  public contact:iContact[]= [];
  public errorMessage:string | null=null;


  constructor(private contactService: ContactService) {}

  ngOnInit(): void {
    this.loading = true;
    this.contactService.getAllContacts().subscribe((data:iContact[])=>{
      this.contact=data;
      this.loading=false;
    });
  }
  }

