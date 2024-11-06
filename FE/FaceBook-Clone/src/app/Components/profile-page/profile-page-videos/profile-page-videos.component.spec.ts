import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilePageVideosComponent } from './profile-page-videos.component';

describe('ProfilePageVideosComponent', () => {
  let component: ProfilePageVideosComponent;
  let fixture: ComponentFixture<ProfilePageVideosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfilePageVideosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProfilePageVideosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
