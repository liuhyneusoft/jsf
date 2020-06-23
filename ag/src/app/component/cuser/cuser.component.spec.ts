import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CuserComponent } from './cuser.component';

describe('CuserComponent', () => {
  let component: CuserComponent;
  let fixture: ComponentFixture<CuserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CuserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CuserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
