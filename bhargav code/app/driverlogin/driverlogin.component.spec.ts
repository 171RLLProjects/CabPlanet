import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DriverloginComponent } from './driverlogin.component';

describe('DriverloginComponent', () => {
  let component: DriverloginComponent;
  let fixture: ComponentFixture<DriverloginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DriverloginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DriverloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
