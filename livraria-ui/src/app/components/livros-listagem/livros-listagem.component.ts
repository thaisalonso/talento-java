import { Component, OnInit } from '@angular/core';
import { Livro } from '../../Livro';
import { LivrosService } from '../../services/livros.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-livros-listagem',
  templateUrl: './livros-listagem.component.html',
  styleUrls: ['./livros-listagem.component.css']
})
export class LivrosListagemComponent implements OnInit {

  livro: Livro;
  livros: Array<Livro>;
  livroSelecionado: Livro;
  cols: any[];

  constructor(private livrosService: LivrosService, private router: Router) { }

  ngOnInit() {
    this.livroSelecionado = {} as Livro;

    this.cols = [
      { field: 'titulo', header: 'Título' },
      { field: 'descricao', header: 'Descrição' },
      { field: 'autor', header: 'Autor'},
      { field: 'valor', header: 'Valor'}
    ];
  }

  buscar(tipoBusca: string, filtro: string) {
    switch (tipoBusca) {
      case 'buscaPorTitulo':
        this.livrosService.buscarPorTitulo(filtro)
          .subscribe(data => this.livros = data);
      break;
      case 'buscaPorAutor':
      this.livrosService.buscarPorAutor(filtro)
          .subscribe(data => this.livros = data);
      break;
    }
  }

  editar() {
    this.livrosService.prepararEditar(this.livroSelecionado);
    this.router.navigate(['/cadastroLivro']);
  }

  excluir() {
    this.livrosService.excluir(this.livroSelecionado.codigo);
    console.log('codigo: ', this.livroSelecionado.codigo);
  }

  limpar() {
    this.livros = null;
  }

}
