package aplicacao;

import entidades.GerenciadorProdutos;
import entidades.Produto;

public class Programa {
    public static void main(String[] args) {
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();

        // Exibindo os produtos de todas as categorias
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Produto produto = gerenciador.getProdutos(i, j);
                System.out.println("Categoria: " + i + ", Produto: " + produto.getNome() + ", Preço: " + produto.getValor() + ", Quantidade: " + produto.getQuantidade());
            }
        }

    }
}
