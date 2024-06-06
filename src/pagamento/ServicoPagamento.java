package pagamento;

public interface ServicoPagamento {
    void realizarPagamento(String nome, double valor);
    void exibirDetalhesPagamento(String nome, double valor);
}
