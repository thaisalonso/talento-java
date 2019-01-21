import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PedidoCadastroComponent } from './pedido-cadastro.component';

describe('PedidoCadastroComponent', () => {
  let component: PedidoCadastroComponent;
  let fixture: ComponentFixture<PedidoCadastroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PedidoCadastroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PedidoCadastroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
