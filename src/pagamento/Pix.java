package pagamento;

public class Pix implements Pagamento{
    @Override
    public void realizarPagamento(double valor) {
        System.out.println("Pagamento de " + valor + " realizado via Pix.");
    }

}
