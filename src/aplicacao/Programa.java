package aplicacao;

import entidades.Comprador;
import entidades.Produto;
import entidades.GerenciadorProdutos;

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
        int categoria = 0;
        // Loop para comprar produtos
        boolean continuarComprando = true;
        while (continuarComprando) {
            do{
            System.out.println("-=-=-=-=-=-=- Menu de compras -=-=-=-=-=-=-");
            System.out.print("[1] Bebidas\n[2] Livros\n[3] Eletrônicos\n[4] Roupas\n[5] Alimentos\n [0] Sair\n>>");
            categoria = sc.nextInt();
            GerenciadorProdutos gerenciador = new GerenciadorProdutos();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            switch (categoria) {
                case 0:
                    continuarComprando = false;
                    categoria = 0;
                    break;
                case 1:
                    System.out.println("Bebidas:");
                    for(int i = 0; i < 5; i++) {
                        System.out.println(gerenciador.getProdutos(0, i));
                    }
                    break;
                case 2:
                    System.out.println("Livros:");
                    for(int i = 0; i < 5; i++) {
                        System.out.println(gerenciador.getProdutos(1, i));
                    }
                    break;
                case 3:
                    System.out.println("Eletrônicos:");
                    for(int i = 0; i < 5; i++) {
                        System.out.println(gerenciador.getProdutos(2, i));
                    }
                    break;
                case 4:
                    System.out.println("Roupas:");
                    for(int i = 0; i < 5; i++) {
                        System.out.println(gerenciador.getProdutos(3, i));
                    }
                    break;
                case 5:
                    System.out.println("Alimentos:");
                    for(int i = 0; i < 5; i++) {
                        System.out.println(gerenciador.getProdutos(4, i));
                    }
                    break;
                default:
                    System.out.println("Categoria inválida.");
                    break;
            }
            }while(categoria != 0);

            System.out.print("Código do produto desejado: ");
            sc.nextLine(); // Limpa o buffer de entrada

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
