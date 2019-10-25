import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddvehicletypeComponent } from './addvehicletype.component';

describe('AddvehicletypeComponent', () => {
  let component: AddvehicletypeComponent;
  let fixture: ComponentFixture<AddvehicletypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddvehicletypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddvehicletypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
