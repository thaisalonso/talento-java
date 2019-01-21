import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pedido } from '../Pedido';

@Injectable({
  providedIn: 'root'
})
export class PedidosService {

  private url = 'http://localhost:8080/pedidos';

  constructor(private http: HttpClient) { }

  incluir(pedido: Pedido): Observable<any> {
    return this.http.post(this.url, pedido);
  }

  listar() {
    return this.http.get<any>(this.url);
  }
}
