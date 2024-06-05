package aplicacao;
import entidades.Comprador;

import java.util.Scanner;

import static aplicacao.UX.*;
import static aplicacao.Logo.logo;

public class Programa {
    public static Comprador comprador = new Comprador();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        logo();
        telaDeLogin();
        limparTela();
        logo();
        telaDeCompra();
        comprador.fazerLogout();
        System.out.println("Você saiu da sua conta.");
        sc.nextLine();
    }
}