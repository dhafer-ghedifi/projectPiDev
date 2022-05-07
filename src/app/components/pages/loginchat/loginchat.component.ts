import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user.model';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-loginchat',
  templateUrl: './loginchat.component.html',
  styleUrls: ['./loginchat.component.scss']
})
export class LoginchatComponent implements OnInit {


  public username = '';
 // public email = '';
  constructor(private router: Router, private userService: UserService) { }

  ngOnInit(): void {
  }
  login() {
    
    this.userService.loginUser(this.username ).subscribe((data: any) => {
      this.router.navigate(['/chat', data.userId]);
    })
  }
}
