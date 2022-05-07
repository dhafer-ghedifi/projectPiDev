import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddChatroomComponent } from './add-chatroom.component';

describe('AddChatroomComponent', () => {
  let component: AddChatroomComponent;
  let fixture: ComponentFixture<AddChatroomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddChatroomComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddChatroomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
