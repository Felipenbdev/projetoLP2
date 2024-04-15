package entidades;

import java.util.Scanner;

public class Comprador extends Usuario{
    public static GerenciadorProdutos gerenciador = new GerenciadorProdutos();

    public Comprador() {
    }

    public Comprador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public Produto fazerCompra(String nomeProduto) {
        Scanner sc = new Scanner(System.in);
        int quant;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Produto produto = gerenciador.getProdutos(i, j);
                if (produto.getNome().toLowerCase().contains(nomeProduto.toLowerCase())) {
                    // Produto encontrado
                    if (produto.getQuantidade() == 0) {
                        // Produto fora de estoque
                        System.out.println("O produto " + produto.getNome() + " está fora de estoque.");
                        return null;
                    }

                    System.out.println(produto);
                    System.out.print("Confirma o produto? [s/n] \n>> ");
                    if (sc.next().toLowerCase().charAt(0) == 's') {
                        do {
                            System.out.print("digite a quantidade de unidades do produto\n>> ");
                            quant = sc.nextInt();
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                            calcularPreco(produto, quant);
                            if(quant <= produto.getQuantidade() && quant>0) {
                                gerenciador.diminuirQuantidadeProduto(i, j, quant);
                                finalizarCompra(produto, quant);
                                return produto;
                            }
                            System.out.println("quantidade de unidades nao disponivel ou invalida, digite novamente!");
                        }while(quant > produto.getQuantidade() || quant<=0);
                    } else {

                        System.out.println("Produto não confirmado. Continuando a busca...");
                        return null;
                    }
                }
            }
        }

        // Se nenhum produto foi encontrado, exibe uma mensagem e retorna null
        System.out.println("O produto que digitou não existe.");
        return null;
    }
    public double calcularPreco(Produto produto, int quantidade) {
        return produto.getValor() * quantidade;

    }
    public void finalizarCompra(Produto produto, int quantidade) {
        double preco = calcularPreco(produto, quantidade);
        System.out.println("Compra finalizada com sucesso!");
        System.out.println("Valor total: R$ " + preco);
    }




}
