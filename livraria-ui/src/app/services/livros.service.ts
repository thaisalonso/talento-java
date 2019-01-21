import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Livro } from '../Livro';

@Injectable({
  providedIn: 'root'
})
export class LivrosService {

  private url = 'http://localhost:8080/livros/';
  private livroEditar: Livro;

  constructor(private http: HttpClient) { }

  incluir(livro: Livro): Observable<any> {
    return this.http.post(this.url, livro);
  }

  listar() {
    return this.http.get<any>(this.url);
  }

  buscar(codigo: string) {
    const params = new HttpParams().set('codigo', codigo);
    return this.http.get<any>(this.url, {params});
  }

  excluir(codigo: string) {
    this.http.delete(this.url + codigo)
    .subscribe();
  }

  livroSelecionado(): Livro {
    return this.livroEditar || {} as Livro;
  }

  prepararEditar(livroEditar: Livro) {
    this.livroEditar = livroEditar;
  }

  buscarPorTitulo(titulo: string) {
    const params = new HttpParams().set('titulo', titulo);
    return this.http.get<any>(this.url, {params});
  }

  buscarPorAutor(autor: string) {
    const params = new HttpParams().set('autor', autor);
    return this.http.get<any>(this.url, {params});
  }
}
