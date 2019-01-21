import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { Cliente } from '../../Cliente';
import { ClientesService } from '../../services/clientes.service';

@Component({
  selector: 'app-cliente-cadastro',
  templateUrl: './cliente-cadastro.component.html',
  styleUrls: ['./cliente-cadastro.component.css']
})
export class ClienteCadastroComponent implements OnInit {

  cliente: Cliente;
  clientes: Array<Cliente>;
  clienteSelecionado: Cliente;
  cols: any[];

  constructor(private clientesService: ClientesService, private router: Router) { }

  ngOnInit() {
    this.cliente = this.clientesService.clienteSelecionado();

    this.cols = [
      { field: 'cpf', header: 'CPF' },
      { field: 'nome', header: 'Nome' }
    ];
  }

  incluir(frm: FormGroup) {
    this.clientes = [] as Array<Cliente>;
    this.clientesService.incluir(this.cliente)
      .subscribe(response => this.router.navigate(['/listagemCliente']));
  }

  buscar(tipoBusca: string, filtro: string) {
    switch (tipoBusca) {
      case 'buscaPorCpf':
        this.clientesService.buscar(filtro)
          .subscribe(data => this.clientes = data);
      break;
      case 'buscarPorNome':
      break;
    }
  }

  editar() {
    this.clientesService.prepararEditar(this.clienteSelecionado);
    this.router.navigate(['/cadastroCliente']);
  }

  excluir() {
    this.clientesService.excluir(this.clienteSelecionado.codigo);
  }

  limpar() {
    this.clientes = null;
  }

}
