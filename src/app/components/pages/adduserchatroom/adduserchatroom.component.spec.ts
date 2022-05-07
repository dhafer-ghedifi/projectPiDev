import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdduserchatroomComponent } from './adduserchatroom.component';

describe('AdduserchatroomComponent', () => {
  let component: AdduserchatroomComponent;
  let fixture: ComponentFixture<AdduserchatroomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdduserchatroomComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdduserchatroomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
