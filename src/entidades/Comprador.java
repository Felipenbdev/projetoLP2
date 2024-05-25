package entidades;

import estoque.Eletronico;
import estoque.GerenciadorProdutos;
import estoque.Livro;
import estoque.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comprador extends Usuario{
    public static estoque.GerenciadorProdutos gerenciador = new GerenciadorProdutos();

    public Comprador() {
    }

    public Comprador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public estoque.Produto fazerCompra(int categoria) {
        List<Produto> produtosEncontrados = new ArrayList<>();
        List<Produto> produtos = gerenciador.getProdutos();
        for (Produto produto : produtos) {
            switch (categoria){
                case 1:
                    System.out.print((produto instanceof Livro) ? produto.toString(): "");
                    break;
                case 2:
                    System.out.print((produto instanceof Eletronico) ? produto.toString(): "");
                    break;
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("\nDigite o nome do produto: ");
        String nomeProduto = sc.nextLine();
        int quant;
        for(Produto produto: produtos){
            if (produto.getNome().toLowerCase().contains(nomeProduto.toLowerCase())){
                // Produto encontrado
                if (produto.getQuantidade() > 0) {
                    produtosEncontrados.add(produto);
                }
            }
        }
        if(produtosEncontrados.isEmpty()){
            System.out.println("nao houve resultados na sua busca :( tente novamente");
            return null;
        }
        int i = 1;
        for(Produto produto: produtosEncontrados){
            System.out.printf("\n[%d] %s",i,produto.getNome());
            i++;
        }

        System.out.print("\n[0] Sair\n--> ");
        int escolha = sc.nextInt();
        if(escolha == 0){
            System.out.println("Saindo! ");
            return null;
        }else{
            finalizarCompra(produtosEncontrados.get(escolha-1),sc);
            return produtosEncontrados.get(escolha-1);
        }
    }

    public void finalizarCompra(Produto produto,Scanner sc) {
        System.out.print("Digite a quantidade de produtos que deseja comprar: ");
        int quantidade = sc.nextInt();
        if(quantidade <= produto.getQuantidade() && quantidade>0) {
            double preco = produto.getValor() * quantidade;
            System.out.println("Compra finalizada com sucesso!");
            System.out.println("Valor total: R$ " + preco);
            produto.diminuirQuantidade(quantidade);
        }else{
            System.out.println("Quantidade invalida! Digite novamente.");
            finalizarCompra(produto,sc);
        }
    }
}