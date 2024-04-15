package aplicacao;
import entidades.Comprador;
import static aplicacao.UX.*;
import static aplicacao.Logo.logo;

public class Programa {
    public static Comprador comprador = new Comprador();
    public static void main(String[] args) {
        logo();
        telaDeLogin();
        limparTela();
        logo();
        telaDeCompra();
        comprador.fazerLogout();
        System.out.println("Você saiu da sua conta.");
    }
}
