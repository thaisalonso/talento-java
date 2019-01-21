import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { Livro } from '../../Livro';
import { LivrosService } from '../../services/livros.service';

@Component({
  selector: 'app-livro-cadastro',
  templateUrl: './livro-cadastro.component.html',
  styleUrls: ['./livro-cadastro.component.css']
})
export class LivroCadastroComponent implements OnInit {

  livro: Livro;
  livros: Array<Livro>;

  constructor(private livrosService: LivrosService, private router: Router) { }

  ngOnInit() {
    this.livro = this.livrosService.livroSelecionado();
  }

  incluir(frm: FormGroup) {
    this.livros = [] as Array<Livro>;
    this.livrosService.incluir(this.livro)
      .subscribe(response => this.router.navigate(['/listagemLivro']));
  }

}
