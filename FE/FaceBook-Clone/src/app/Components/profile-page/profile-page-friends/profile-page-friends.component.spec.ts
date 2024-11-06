import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilePageFriendsComponent } from './profile-page-friends.component';

describe('ProfilePageFriendsComponent', () => {
  let component: ProfilePageFriendsComponent;
  let fixture: ComponentFixture<ProfilePageFriendsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfilePageFriendsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProfilePageFriendsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
