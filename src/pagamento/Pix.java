package pagamento;
public class Pix implements Pagamento{
    @Override
    public void realizarPagamento(String nome, double valor) {
        System.out.println("Código PIX gerado: " + Math.random());
        System.out.println("Valor: R$" + valor);
        System.out.println("Sr(a). " + nome + ", realize o pagamento via PIX para o código acima em até 30 minutos.");
        
    }

}
