package pagamento;

public class Boleto implements Pagamento{

    @Override
    public void realizarPagamento(String nome, double valor) {
        
        System.out.println("Boleto gerado para pagamento de R$" + valor + ".");
    }

}
