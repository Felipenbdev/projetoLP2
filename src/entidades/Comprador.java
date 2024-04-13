package entidades;

import java.util.Scanner;

public class Comprador extends Usuario{
    public Comprador() {
    }

    public Comprador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public static Produto fazerCompra(String nomeProduto) {
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Produto produto = gerenciador.getProdutos(i,j);
                if (produto.getNome().toLowerCase().contains(nomeProduto.toLowerCase())) {
                    System.out.println(produto);
                    System.out.print("Confirma o produto? [s/n] \n>> ");
                    if (sc.next().toLowerCase().charAt(0) == 's' && produto.isDisponivel()) {
                        gerenciador.diminuirQuantidadeProduto(i,j,1);
                        return produto;
                    }
                }
            }
        }
        System.out.println("o produto que digitou nao existe ou esta fora de estoque no momento");
        return null; 
   }

}
