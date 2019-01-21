import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  private url = 'http://localhost:8080/clientes/';
  private clienteEditar: Cliente;

  constructor(private http: HttpClient) { }

  incluir(cliente: Cliente): Observable<any> {
    return this.http.post(this.url, cliente);
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

  clienteSelecionado(): Cliente {
    return this.clienteEditar || {} as Cliente;
  }

  prepararEditar(clienteEditar: Cliente) {
    this.clienteEditar = clienteEditar;
  }

  buscarPorNome(nome: string) {
    const params = new HttpParams().set('nome', nome);
    return this.http.get<any>(this.url, {params});
  }

  buscarPorCpf(cpf: string) {
    const params = new HttpParams().set('cpf', cpf);
    return this.http.get<any>(this.url, {params});
  }

}
