import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicletypelistComponent } from './vehicletypelist.component';

describe('VehicletypelistComponent', () => {
  let component: VehicletypelistComponent;
  let fixture: ComponentFixture<VehicletypelistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehicletypelistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicletypelistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
