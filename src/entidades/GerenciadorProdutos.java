package entidades;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos {
        private static List<Produto> listaProdutos = new ArrayList<>();

        public static void adicionarProduto(Produto produto) {
            listaProdutos.add(produto);
        }
        public static void removerProduto(Produto produto) {
        listaProdutos.remove(produto);
        }

        public static List<Produto> getTodosProdutos() {
            return listaProdutos;
        }
}


