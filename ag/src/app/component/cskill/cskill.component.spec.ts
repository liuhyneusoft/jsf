import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CskillComponent } from './cskill.component';

describe('CskillComponent', () => {
  let component: CskillComponent;
  let fixture: ComponentFixture<CskillComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CskillComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CskillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
