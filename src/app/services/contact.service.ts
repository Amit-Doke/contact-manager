import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { iContact } from '../models/iContact';
import { iGroup } from '../models/iGroup';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private serverUrl : string = 'http://localhost:9000'; // JSON SERVER URL

  constructor(private httpClient : HttpClient) { }

// to get all contacts

  public getAllContacts() : Observable<iContact[]>
  {
    let dataURl : string =`${this.serverUrl}/contacts`;
    return this.httpClient.get<iContact[]>(dataURl).pipe(catchError(this.handleError));
  }

  // to get single contact

  public getContact(contactId : string):Observable<iContact>
  {
    let dataURl: string = `${this.serverUrl}/contacts/${contactId}`;
    return this.httpClient.get<iContact>(dataURl).pipe(catchError(this.handleError));
  }


  // to create a contact

  public createContact(contact:iContact) : Observable<iContact>
  {
    let dataURl : string =`${this.serverUrl}/contacts`;
    return this.httpClient.post<iContact>(dataURl, contact).pipe(catchError(this.handleError));
  }

  // to update a contact

  public updateContact(contact:iContact, contactId : string) : Observable<iContact>
  {
    let dataURl : string =`${this.serverUrl}/contacts/${contactId}`;
    return this.httpClient.put<iContact>(dataURl, contact).pipe(catchError(this.handleError));
  }
  
  
  // to delete a contact

  public deleteContact(contactId : string) : Observable<{}>
  {
    let dataURl : string =`${this.serverUrl}/contacts/${contactId}`;
    return this.httpClient.delete<{}>(dataURl).pipe(catchError(this.handleError));
  }


  // to get all groups

  public getAllGroups() : Observable<iGroup[]>
  {
    let dataURl : string =`${this.serverUrl}/groups`;
    return this.httpClient.get<iGroup[]>(dataURl).pipe(catchError(this.handleError));
  }

  // to get single group

  public getGroup(contact : iContact):Observable<iGroup>
  {
    let dataURl: string = `${this.serverUrl}/groups/${contact.groupid}`;
    return this.httpClient.get<iGroup>(dataURl).pipe(catchError(this.handleError));
  }


  // error handling
  public handleError(error:HttpErrorResponse){
    let errorMessage:string='';
    if (error.error instanceof ErrorEvent)
    {
      //client side error
      errorMessage = `Error:${error.error.message}`
    }
    else
    {
      // server side error
      errorMessage= `Status : ${error.status} \n Message : ${error.message}`;
    }
    return throwError(errorMessage);
  }


}


