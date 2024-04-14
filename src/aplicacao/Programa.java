package aplicacao;
import entidades.Comprador;
import static aplicacao.UX.*;

public class Programa {
    public static Comprador comprador = new Comprador();
    public static void main(String[] args) {
        System.out.println("_-=-=-=-=-=-=-=-=-=-= Bem-vindo a Loja Online NOZAMA =-=-=-=-=-=-=-=-=-=-_");
        //telaDeLogin();
        limparTela();
        telaDeCompra();
        comprador.fazerLogout();
        System.out.println("Você saiu da sua conta.");
    }
}
