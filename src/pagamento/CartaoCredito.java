package pagamento;
import java.util.Scanner;

public class CartaoCredito implements Pagamento{

    @Override
    public void realizarPagamento(String nome, double valor) {
        double juros = 0.05;
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("[Cartão de Crédito] Insira os dados do cartão:");
        System.out.print("Número do cartão: ");
        String numeroCartao = sc.nextLine();
        System.out.print("Nome do titular: ");
        String nomeTitular = sc.nextLine();
        System.out.print("Data de validade: ");
        String dataValidade = sc.nextLine();
        System.out.print("CVV: ");
        String cvv = sc.nextLine();
        System.out.println("-----------------------------------");  
        System.out.println("Valor da compra com juros: R$ " + valor + (juros*valor));
        System.out.println("-----------------------------------");
        
    }


}
