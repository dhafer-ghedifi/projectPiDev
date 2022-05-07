import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

//design pattern 
import { Observable } from'rxjs';
import { chatroom } from '../model/chatroom.model';
import { abonne } from '../model/abonne.model';
const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} )
  };
@Injectable({
  providedIn: 'root'
})
export class ChatroomService {
  chatroomsUrl: string = 'http://localhost:8081/chatroom/retrieve-all-chatrooms';
  constructor(private _http:HttpClient) { }
  getChatrooms() : Observable<chatroom[]> {
    return this._http.get<chatroom[]>(this.chatroomsUrl);}
    supprimerchatroom(id:number){
 return this._http.delete(`http://localhost:8081/chatroom/remove-chatroom/${id}`);
  }
  baseUrl = "http://localhost:8081/chatroom/";

  addUri='http://localhost:8081/chatroom/add-Chatroom'
    addChatroom( chatroom:chatroom):Observable<chatroom>{
      return this._http.post<chatroom>('http://localhost:8081/chatroom/add-Chatroom',chatroom, httpOptions);
      }
      updateChatroom(chatr:chatroom) : Observable<chatroom>
      {
      return this._http.put<chatroom>('http://localhost:8081/chatroom/modify-chatroom', chatr, httpOptions);
      }
      adduserchatroom(a:abonne,idChatroom:number): Observable<abonne>
      {
        let uri="add-user/"+idChatroom;
      return this._http.post<abonne>(this.baseUrl+uri,a,httpOptions);
      }
      getChatroomByName(name:string) : Observable<chatroom[]>{
        return this._http.get<chatroom[]>("http://localhost:8081/chatroom/searchbyname/"+name);
      }
      updateProduit(ch :chatroom) : Observable<chatroom>
      {
      return this._http.put<chatroom>('http://localhost:8081/chatroom/modify-chatroom', ch, httpOptions);
      }

}

