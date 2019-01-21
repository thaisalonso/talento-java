import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { Pedido } from '../../Pedido';
import { Livro } from '../../Livro';
import { PedidosService } from '../../services/pedidos.service';
import { LivrosService } from '../../services/livros.service';
import { Cliente } from '../../Cliente';
import { ClientesService } from '../../services/clientes.service';

@Component({
  selector: 'app-pedido-cadastro',
  templateUrl: './pedido-cadastro.component.html',
  styleUrls: ['./pedido-cadastro.component.css']
})
export class PedidoCadastroComponent implements OnInit {

  pedido: Pedido;
  pedidos: Array<Pedido>;

  livros: Array<Livro>;
  livrosSelecionados: Array<Livro>;

  clientes: Array<Cliente>;
  clienteSelecionado: Cliente;

  constructor(private pedidosService: PedidosService, private livrosService: LivrosService,
    private clientesService: ClientesService, private router: Router) { }

  ngOnInit() {
    this.listarLivros();
    this.listarClientes();
  }

  incluir(frm: FormGroup) {
    this.pedidos = [] as Array<Pedido>;
    this.pedido = {} as Pedido;
    console.log('cliente selecionado: ', this.clienteSelecionado);
    console.log('livros selecionados: ', this.livrosSelecionados);
    this.pedido.cliente = this.clienteSelecionado;
    this.pedido.livros = this.livrosSelecionados;
    this.pedidosService.incluir(this.pedido)
      .subscribe(response => this.router.navigate(['/listagemPedido']));
  }

  listarLivros() {
    this.livrosService.listar()
      .subscribe(data => this.livros = data);
  }

  listarClientes() {
    this.clientesService.listar()
      .subscribe(data => this.clientes = data);
  }

}
