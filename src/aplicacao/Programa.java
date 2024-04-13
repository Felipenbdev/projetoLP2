package aplicacao;

import entidades.Comprador;
import entidades.Produto;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comprador comprador = null;

        System.out.println("Bem-vindo a Loja taltaltal");

        comprador = criarComprador(sc);

        boolean loggedIn = false;

        while (!loggedIn) {
            menuLogin();
            int ops = sc.nextInt();
            sc.nextLine(); // Limpa o buffer de entrada

            switch (ops) {
                case 1:
                    System.out.println("Você já está cadastrado. Por favor, faça login.");
                    break;
                case 2:
                    if (comprador != null) {
                        loggedIn = fazerLogin(sc, comprador);
                    } else {
                        System.out.println("Você ainda não está cadastrado. Por favor, cadastre-se primeiro.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        // Loop para comprar produtos
        boolean continuarComprando = true;
        while (continuarComprando) {
            System.out.println("Pagina de pesquisa");
            System.out.print("Digite o nome do item que deseja comprar: ");
            Produto produto = comprador.fazerCompra(sc.nextLine());
            if(produto != null) {
                System.out.println("Produto comprado: " + produto.getNome());

                System.out.print("Deseja comprar mais algum produto? (s/n): ");
                String resposta = sc.nextLine();
                continuarComprando = resposta.equalsIgnoreCase("s");
            }
        }

        // Após o loop de compras, faz o logout
        comprador.fazerLogout();
        System.out.println("Você saiu da sua conta.");
    }

    public static void menuLogin() {
        System.out.println("1-Novo usuário");
        System.out.println("2-Fazer login");
    }

    public static Comprador criarComprador(Scanner sc) {
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();
        return new Comprador(nome, email, senha);
    }

    public static boolean fazerLogin(Scanner sc, Comprador comprador) {
        System.out.print("Digite seu email: ");
        String emailLogin = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senhaLogin = sc.nextLine();
        return comprador.autenticacao(emailLogin, senhaLogin);
    }
}
