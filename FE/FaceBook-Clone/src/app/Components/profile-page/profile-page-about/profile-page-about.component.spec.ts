import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilePageAboutComponent } from './profile-page-about.component';

describe('ProfilePageAboutComponent', () => {
  let component: ProfilePageAboutComponent;
  let fixture: ComponentFixture<ProfilePageAboutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfilePageAboutComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProfilePageAboutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
