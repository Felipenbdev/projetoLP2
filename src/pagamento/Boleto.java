package pagamento;

public class Boleto implements ServicoPagamento {

    @Override
    public void realizarPagamento(String nome, double valor) {
        System.out.println("Boleto gerado para pagamento de R$" + valor + ".");
    }

    @Override
    public void exibirDetalhesPagamento(String nome, double valor) {
        System.out.println("Detalhes do pagamento via Boleto:");
        System.out.println("Nome: " + nome);
        System.out.println("Valor: R$" + valor);
    }
}
