import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LivrosListagemComponent } from './livros-listagem.component';

describe('LivrosListagemComponent', () => {
  let component: LivrosListagemComponent;
  let fixture: ComponentFixture<LivrosListagemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LivrosListagemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LivrosListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
