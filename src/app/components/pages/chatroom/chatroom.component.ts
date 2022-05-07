import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { chatroom } from 'src/app/model/chatroom.model';
import { ChatroomService } from 'src/app/shared/chatroom.service';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { abonne } from 'src/app/model/abonne.model';


@Component({
  selector: 'app-chatroom',
  templateUrl: './chatroom.component.html',
  styleUrls: ['./chatroom.component.scss']
})
export class ChatroomComponent implements OnInit {
  currentChatroom = new chatroom();
  listChatrooms:chatroom[];
  searchtext:any;
  chatRoomName:string;
  closeResult:string;
  Chatroom : chatroom = new chatroom ();
  a:abonne=new abonne();
  constructor(private _service:ChatroomService,   private router :Router,private toastr: ToastrService, private modalService : NgbModal) { }

  ngOnInit(): void {this._service.getChatrooms().subscribe(ch => {
    console.log(ch);
    this.listChatrooms = ch;
    });
  }
  supprimerchatroom(ch:chatroom){
   
  let conf = confirm("Etes-vous sûr ?");
  if (conf)
    this._service.supprimerchatroom(ch.idChatRoom).subscribe(() => {
    console.log("chatroom supprimé");
    this.SuprimerchatroomDuTableau(ch);
    this.toastr.success(' deleted successfully', 'Notification');
  });
}
  SuprimerchatroomDuTableau(chat: chatroom){
    this.listChatrooms.forEach((cur, index) => {
      if(chat.idChatRoom=== cur.idChatRoom) {
      this.listChatrooms.splice(index, 1);
      }
      });
  }
  searchChatroom() {
    this._service.getChatroomByName(this.chatRoomName).subscribe(res => {
      if (res) {
        this.listChatrooms = res ;
      }
    },err =>{
      if (err) {
        this.listChatrooms = [];
      }
    });
  

}
open(content) {
  this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  });
}

private getDismissReason(reason: any): string {
  if (reason === ModalDismissReasons.ESC) {
    return 'by pressing ESC';
  } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
    return 'by clicking on a backdrop';
  } else {
    return `with: ${reason}`;
  }
}
addChatroom(){
  this._service.addChatroom(this.Chatroom).subscribe(()=>this.router.navigateByUrl("/chatroom"));
  this.toastr.success('saved successfully', 'Notification');
}
addUserChatroom(){
  this._service.adduserchatroom(this.a,1).subscribe(()=>this.router.navigateByUrl("/chatroom")); 

    
 

}

open1(content) {
  this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  });
}
updateChatroom() {
  this._service.updateChatroom(this.currentChatroom).subscribe(chatr => {
  this.router.navigate(['chatroom']);
  },(error) => { alert("Problème lors de la modification !"); }
  );
  }
  
}
