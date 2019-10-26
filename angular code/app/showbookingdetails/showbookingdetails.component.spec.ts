import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowbookingdetailsComponent } from './showbookingdetails.component';

describe('ShowbookingdetailsComponent', () => {
  let component: ShowbookingdetailsComponent;
  let fixture: ComponentFixture<ShowbookingdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowbookingdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowbookingdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
