package entidades;

import java.util.Scanner;

public class Comprador extends Usuario{
    public static GerenciadorProdutos gerenciador = new GerenciadorProdutos();

    public Comprador() {
    }

    public Comprador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public static Produto fazerCompra(String nomeProduto) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Produto produto = gerenciador.getProdutos(i,j);
                if (produto.getNome().toLowerCase().contains(nomeProduto.toLowerCase())) {
                    if (produto.getQuantidade() == 0) {
                        System.out.println("O produto " + produto.getNome() + " está fora de estoque.");
                        return null;
                    }
                    System.out.println(produto);
                    System.out.print("Confirma o produto? [s/n] \n>> ");
                    if (sc.next().toLowerCase().charAt(0) == 's') {
                        gerenciador.diminuirQuantidadeProduto(i,j,1);
                        return produto;
                    }
                }
            }
        }
        System.out.println("O produto que digitou não existe ou está fora de estoque no momento");
        return null;
    }
}
