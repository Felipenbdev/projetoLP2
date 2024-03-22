package entidades;

public class GerenciadorProdutos {
    private Produto[] produtos;

    public GerenciadorProdutos(int capacidade) {
        this.produtos = new Produto[capacidade];
        // Adiciona produtos pré-definidos
        adicionarProdutosPreDefinidos();
    }

    private void adicionarProdutosPreDefinidos() {

    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }
}
