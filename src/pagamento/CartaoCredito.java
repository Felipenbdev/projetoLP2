package pagamento;

import java.util.Scanner;

public class CartaoCredito implements ServicoPagamento {

    @Override
    public void realizarPagamento(String nome, double valor) {
        double juros = 0.05;
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("[Cartão de Crédito] Insira os dados do cartão:");
        System.out.print("Número do cartão: ");
        String numeroCartao = sc.nextLine();
        System.out.print("Nome do titular: ");
        String nomeTitular = sc.nextLine();
        System.out.print("Data de validade: ");
        String dataValidade = sc.nextLine();
        System.out.print("CVV: ");
        String cvv = sc.nextLine();
        System.out.println("-------------------------");
        System.out.println("Valor da compra: R$ " + (valor + (juros * valor)));
    }

    @Override
    public void exibirDetalhesPagamento(String nome, double valor) {
        System.out.println("-------------------------");
        System.out.println("Detalhes do pagamento via Cartão de Crédito:");
        System.out.println("Nome: " + nome);
        System.out.println("Valor: R$" + valor);
        System.out.println("Juros: 5%");
        System.out.println("Valor com juros: R$" + (valor + (valor * 0.05)));
        
    }
}
