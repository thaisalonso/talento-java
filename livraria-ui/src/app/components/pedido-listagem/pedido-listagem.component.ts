import { Component, OnInit } from '@angular/core';
import { Pedido } from '../../Pedido';
import { PedidosService } from '../../services/pedidos.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pedido-listagem',
  templateUrl: './pedido-listagem.component.html',
  styleUrls: ['./pedido-listagem.component.css']
})
export class PedidoListagemComponent implements OnInit {

  pedido: Pedido;
  pedidos: Array<Pedido>;
  pedidoSelecionado = {} as Pedido;
  cols: any[];
  colsLivros: any[];

  constructor(private pedidosService: PedidosService, private router: Router) { }

  ngOnInit() {
    this.pedidoSelecionado = {} as Pedido;
    this.listar();

    this.cols = [
      { field: 'codigo', header: 'Código' },
      { field: 'cadastro', header: 'Data Cadastro' },
      { field: 'valor', header: 'Valor'},
      { field: 'quantidade', header: 'Quantidade'}
    ];

    this.colsLivros = [
      { field: 'titulo', header: 'Título' },
      { field: 'descricao', header: 'Descrição' },
      { field: 'autor', header: 'Autor'},
      { field: 'valor', header: 'Valor'}
    ];
  }

  listar() {
    this.pedidosService.listar()
      .subscribe(data => this.pedidos = data);
  }

}
