import { Component, OnInit } from '@angular/core';
import { Cliente } from '../../Cliente';
import { ClientesService } from '../../services/clientes.service';
import { Router } from '@angular/router';
import { fromEventPattern } from 'rxjs';

@Component({
  selector: 'app-cliente-listagem',
  templateUrl: './cliente-listagem.component.html',
  styleUrls: ['./cliente-listagem.component.css']
})
export class ClienteListagemComponent implements OnInit {

  cliente: Cliente;
  clientes: Array<Cliente>;
  clienteSelecionado: Cliente;
  cols: any[];

  constructor(private clienteService: ClientesService, private router: Router) { }

  ngOnInit() {
    this.clienteSelecionado = {} as Cliente;

    this.cols = [
      { field: 'cpf', header: 'CPF' },
      { field: 'nome', header: 'Nome' }
    ];
  }

  buscar(tipoBusca: string, filtro: string) {
    switch (tipoBusca) {
      case 'buscaPorNome':
        this.clienteService.buscarPorNome(filtro)
          .subscribe(data => this.clientes = data);
      break;
      case 'buscaPorCpf':
      this.clienteService.buscarPorCpf(filtro)
          .subscribe(data => this.clientes = data);
      break;
    }
  }

  editar() {
    this.clienteService.prepararEditar(this.clienteSelecionado);
    this.router.navigate(['/cadastroCliente']);
  }

  excluir() {
    this.clienteService.excluir(this.clienteSelecionado.codigo);
  }

  limpar() {
    this.clientes = null;
  }

}
