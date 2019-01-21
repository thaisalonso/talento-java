import { Cliente } from './Cliente';
import { Livro } from './Livro';

export interface Pedido {
    cliente: Cliente;
    livros: Livro[];
    cadastro: string;
    valor: number;
    quantidade: number;
}
