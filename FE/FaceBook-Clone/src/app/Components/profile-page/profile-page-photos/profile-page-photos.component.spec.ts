import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilePagePhotosComponent } from './profile-page-photos.component';

describe('ProfilePagePhotosComponent', () => {
  let component: ProfilePagePhotosComponent;
  let fixture: ComponentFixture<ProfilePagePhotosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfilePagePhotosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProfilePagePhotosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
