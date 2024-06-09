package estoque;

public interface ServicoProdutos {
    void addProduto(Produto produto);

    void removerProduto(int index);

    void mostrarProdutos();

    void esvaziarProdutos();

    double calcularValorTotal();

    void editarProdutos();

    boolean isVazio();
}