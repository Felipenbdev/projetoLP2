package pagamento;

public class Pix implements ServicoPagamento {

    @Override
    public void realizarPagamento(String nome, double valor) {
        System.out.println("-------------------------");
        System.out.println("Código PIX gerado: " + Math.random());
        System.out.println("Valor: R$" + valor);
        System.out.println("Sr(a). " + nome + ", realize o pagamento via PIX para o código acima em até 30 minutos.");
    }

    @Override
    public void exibirDetalhesPagamento(String nome, double valor) {
        System.out.println("-------------------------");
        System.out.println("[Detalhes do pagamento via PIX]");
        System.out.println("Nome: " + nome);
        System.out.println("Valor: R$" + valor);
        System.out.println("Tempo para pagamento: 30 minutos");
        System.out.println("-------------------------");
    }
}
