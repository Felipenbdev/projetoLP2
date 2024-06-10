package estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carrinho implements ServicoProdutos {

    private static final List<Produto> carrinho = new ArrayList<>();

    @Override
    public void addProduto(Produto produto){
        if(produto != null) {
            carrinho.add(produto);
        }
    }

    @Override
    public void removerProduto(int index){
        carrinho.remove(index);
    }

    @Override
    public void mostrarProdutos(){
        if(carrinho.isEmpty()){
            System.out.println("Carinho vazio!");
        }else{
            System.out.println("Carrinho de Compras:");
            System.out.print("-----------------------------------");
            int i = 1;
            for(Produto produto: carrinho) {
                System.out.printf("\n |-[%d]-|", i);
                System.out.print(produto);
                i++;
            }
        }
    }

    @Override
    public void esvaziarProdutos(){
        carrinho.clear();
    }

    @Override
    public double calcularValorTotal(){
        double preco = 0;
        for(Produto produto: carrinho){
            preco += produto.getQuantidade() * produto.getValor();
        }
        return preco;
    }

    public void editarProdutos(){
        Scanner sc = new Scanner(System.in);
        mostrarProdutos();
        System.out.print("Digite o indice para remover ou [0] para voltar: ");
        int i = sc.nextInt();
        if(i == 0){
            System.out.println("Encerrando edição...");
        }
        else {
            if (i < 0 || carrinho.size() < i) {
                System.out.println("Erro!");
                editarProdutos();
            }
            removerProduto(i - 1);
            System.out.println("Carrinho atualizado!");
            mostrarProdutos();
            if (carrinho.isEmpty()) {
                System.out.println("Encerrando edição...");
            } else {
                System.out.print("Deseja editar mais uma vez? [s] [n]\n>>");
                sc.nextLine(); //buffer
                if (sc.nextLine().equalsIgnoreCase("s")) {
                    editarProdutos();
                } else {
                    System.out.println("Encerrando edição...");
                }
            }
        }
    }

    @Override
    public boolean isVazio(){
        return carrinho.isEmpty();
    }
}