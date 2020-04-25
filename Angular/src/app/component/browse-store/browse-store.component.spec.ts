import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BrowseStoreComponent } from './browse-store.component';

describe('BrowseStoreComponent', () => {
  let component: BrowseStoreComponent;
  let fixture: ComponentFixture<BrowseStoreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BrowseStoreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BrowseStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
