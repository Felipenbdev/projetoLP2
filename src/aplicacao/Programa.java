package aplicacao;
import entidades.Comprador;
import java.util.Scanner;
import static aplicacao.UX.telaDeCompra;
import static aplicacao.UX.telaDeLogin;

public class Programa {
    public static Comprador comprador = new Comprador();
    public static void limparTela(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comprador comprador = null;
        System.out.println("Bem-vindo a Loja taltaltal");
        telaDeLogin();
        limparTela();
        telaDeCompra();
        comprador.fazerLogout();
        System.out.println("Você saiu da sua conta.");
    }
}
