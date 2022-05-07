import { Injectable } from '@angular/core';
import { settings } from '../util/settings';

const headers = new HttpHeaders({
  'Content-Type': 'application/json'
});
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../model/user.model';
import { chatroom } from '../model/chatroom.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {}

  getUsers() {
    return this.http.get('http://localhost:8081/users')
  }

  loginUser(username: string) {
    return this.http.post('http://localhost:8081/login', {username:username})
  }
}