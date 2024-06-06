package estoque;

public interface ServicoCarrinho {
    void addProduto(Produto produto);

    void removerProduto(int index);

    void mostrarProdutos();

    void esvaziarProdutos();

    double calcularValorTotal();

    void editarProdutos();
}
