import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberEtudiantComponent } from './member-etudiant.component';

describe('MemberEtudiantComponent', () => {
  let component: MemberEtudiantComponent;
  let fixture: ComponentFixture<MemberEtudiantComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MemberEtudiantComponent]
    });
    fixture = TestBed.createComponent(MemberEtudiantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
