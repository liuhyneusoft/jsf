import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CpaymentComponent } from './cpayment.component';

describe('CpaymentComponent', () => {
  let component: CpaymentComponent;
  let fixture: ComponentFixture<CpaymentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CpaymentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CpaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
