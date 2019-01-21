import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule, LOCALE_ID } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { InputTextModule } from 'primeng/inputtext';
import { TableModule } from 'primeng/table';
import { ListboxModule } from 'primeng/listbox';

import { RouterModule, Routes } from '@angular/router';

import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LivroCadastroComponent } from './components/livro-cadastro/livro-cadastro.component';
import { LivrosService } from './services/livros.service';
import { LivrosListagemComponent } from './components/livros-listagem/livros-listagem.component';
import { ClienteCadastroComponent } from './components/cliente-cadastro/cliente-cadastro.component';
import { ClienteListagemComponent } from './components/cliente-listagem/cliente-listagem.component';
import { PedidoCadastroComponent } from './components/pedido-cadastro/pedido-cadastro.component';
import { PedidoListagemComponent } from './components/pedido-listagem/pedido-listagem.component';

import {registerLocaleData} from '@angular/common';
import localePt from '@angular/common/locales/pt';
import { CpfPipe } from './CpfPipe';

const appRoutes: Routes = [
  { path: 'cadastroLivro', component: LivroCadastroComponent },
  { path: 'listagemLivro', component: LivrosListagemComponent },
  { path: 'cadastroCliente', component: ClienteCadastroComponent },
  { path: 'listagemCliente', component: ClienteListagemComponent },
  { path: 'cadastroPedido', component: PedidoCadastroComponent },
  { path: 'listagemPedido', component: PedidoListagemComponent },
  { path: '',   redirectTo: '/listagemPedido', pathMatch: 'full' },
];

registerLocaleData(localePt);

@NgModule({
  declarations: [
    AppComponent,
    LivroCadastroComponent,
    LivrosListagemComponent,
    ClienteCadastroComponent,
    ClienteListagemComponent,
    PedidoCadastroComponent,
    PedidoListagemComponent,
    CpfPipe
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    InputTextModule,
    TableModule,
    ListboxModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
    ),
  ],
  providers: [
    LivrosService,
    {
      provide: LOCALE_ID,
      useValue: 'pt-BR'
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
