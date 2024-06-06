package estoque;

import java.util.ArrayList;
import java.util.List;

public class Carrinho implements ServicoCarrinho{

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
        System.out.println("Carrinho de Compras:");
        for(Produto produto: carrinho){
            System.out.println(produto);
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

    public static List<Produto> getCarrinho() {
        return carrinho;
    }
}
