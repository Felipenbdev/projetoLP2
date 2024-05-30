package pagamento;

public class Boleto implements Pagamento{

    public void realizarPagamento(double valor) {
        System.out.println("Boleto gerado para pagamento de " + valor + ".");
    }

}
