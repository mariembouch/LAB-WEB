import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberEnseignantComponent } from '../member-enseignant.component';

describe('MemberEnseignantComponent', () => {
  let component: MemberEnseignantComponent;
  let fixture: ComponentFixture<MemberEnseignantComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MemberEnseignantComponent]
    });
    fixture = TestBed.createComponent(MemberEnseignantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
