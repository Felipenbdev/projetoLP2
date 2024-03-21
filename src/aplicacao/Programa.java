package aplicacao;

import entidades.Comprador;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("TELA DE REGISTRO ");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        System.out.print("Crie sua senha: ");
        String senha = sc.nextLine();

        Comprador c1 = new Comprador(nome,email,senha);
        System.out.println();
        System.out.println("TELA DE LOGIN");
        System.out.print("Digite seu email: ");
        String emailLogin = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senhaLogin = sc.nextLine();

        if(c1.autenticacao(emailLogin, senhaLogin)){
            System.out.println("Deu certo");
        }

        sc.close();

    }
}
