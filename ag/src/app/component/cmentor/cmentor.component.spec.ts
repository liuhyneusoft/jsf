import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CmentorComponent } from './cmentor.component';

describe('CmentorComponent', () => {
  let component: CmentorComponent;
  let fixture: ComponentFixture<CmentorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CmentorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CmentorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
