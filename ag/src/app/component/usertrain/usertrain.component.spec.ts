import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsertrainComponent } from './usertrain.component';

describe('UsertrainComponent', () => {
  let component: UsertrainComponent;
  let fixture: ComponentFixture<UsertrainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsertrainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsertrainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
