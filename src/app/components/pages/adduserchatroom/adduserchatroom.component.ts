import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { abonne } from 'src/app/model/abonne.model';
import { ChatroomService } from 'src/app/shared/chatroom.service';

@Component({
  selector: 'app-adduserchatroom',
  templateUrl: './adduserchatroom.component.html',
  styleUrls: ['./adduserchatroom.component.scss']
})
export class AdduserchatroomComponent implements OnInit {
 
 a:abonne=new abonne();
  constructor(private _service:ChatroomService,  private router :Router) { }

  ngOnInit(): void {
  }
  addUserChatroom(){
    this._service.adduserchatroom(this.a,1).subscribe(()=>this.router.navigateByUrl("/chatroom")); 

      
   
  
  }
}
