import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { chatroom } from 'src/app/model/chatroom.model';
import { ChatroomService } from 'src/app/shared/chatroom.service';

@Component({
  selector: 'app-add-chatroom',
  templateUrl: './add-chatroom.component.html',
  styleUrls: ['./add-chatroom.component.scss']
})
export class AddChatroomComponent implements OnInit {
  Chatroom : chatroom = new chatroom();
  message :string;

  id:number;
  constructor(private _service:ChatroomService,  private router :Router) { }

  ngOnInit(): void {
  }
  addChatroom(){
    this._service.addChatroom(this.Chatroom).subscribe(()=>this.router.navigateByUrl("/chatroom"));
  }
}
