package aplicacao;

import entidades.Comprador;
import entidades.GerenciadorProdutos;
import entidades.Produto;

import static entidades.Comprador.gerenciador;

public class Programa {
    public static void main(String[] args) {


        /*
        // Exibindo os produtos de todas as categorias
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Produto produto = gerenciador.getProdutos(i, j);
                System.out.println("Categoria: " + i + ", Produto: " + produto.getNome() + ", Preço: " + produto.getValor() + ", Quantidade: " + produto.getQuantidade());
            }
        }
        */

        System.out.println("teste 1"+gerenciador.getProdutos(0,0));
        Comprador.fazerCompra("coca");
        System.out.println("teste 2"+gerenciador.getProdutos(0,0));
        Comprador.fazerCompra("coca");
        System.out.println("teste 2"+gerenciador.getProdutos(0,0));
    }
}
