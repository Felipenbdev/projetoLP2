package estoque;

import java.util.ArrayList;
import java.util.List;


public class GerenciadorProdutos{
    private static final List<Produto> produtos = new ArrayList<Produto>();
    public GerenciadorProdutos() {
        estocarProdutos();
    }

    public void estocarProdutos() {
        //livros
        produtos.add(new Livro("Harry Potter", 50.00, 10));
        produtos.add(new Livro("Senhor dos Aneis", 40.00, 10));
        produtos.add(new Livro("O Pequeno Principe", 30.00, 10));
        produtos.add(new Livro("Dom Casmurro", 20.00, 10));
        produtos.add(new Livro("Casa Monstro", 10.00, 10));
        //eletronicos
        produtos.add(new Eletronico("Iphone", 5000.00, 10));
        produtos.add(new Eletronico("Samsung", 4000.00, 10));
        produtos.add(new Eletronico("Motorola", 3000.00, 10));
        produtos.add(new Eletronico("Xiaomi", 2000.00, 10));
        produtos.add(new Eletronico("LG", 1000.00, 10));
        }

        public List<Produto> getProdutos(){
            return produtos;
        }
        
        

}