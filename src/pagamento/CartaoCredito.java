package pagamento;

public class CartaoCredito implements Pagamento{

    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com cartão de crédito.");
    }


}
