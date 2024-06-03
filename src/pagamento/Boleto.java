package pagamento;

public class Boleto implements Pagamento{

    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Boleto gerado para pagamento de " + valor + ".");
    }

}
