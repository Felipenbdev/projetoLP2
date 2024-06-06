package aplicacao;

import entidades.Comprador;
import estoque.Produto;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static aplicacao.Programa.comprador;

public class UX {
    private static Scanner sc = new Scanner(System.in);
    public static List<Produto> carrinho = new ArrayList<>();
    public static void criarComprador() {
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        comprador.setEmail(email);
        comprador.setNome(nome);
        comprador.setSenha(senha);
    }

    public static boolean fazerLogin(Scanner sc, Comprador comprador) {
        System.out.print("Digite seu email: ");
        String emailLogin = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senhaLogin = sc.nextLine();
        return comprador.autenticacao(emailLogin, senhaLogin);
    }
    private static void menuLogin() {
        System.out.print("[1] - Novo usuário \n[2] - Fazer login\n>>");
    }
    public static void telaDeLogin(){
        boolean loggedIn = false;
        //tirar esse while e usar recursividade
        while (!loggedIn) {
            UX.menuLogin();
            int ops = sc.nextInt();
            sc.nextLine();

            switch (ops) {
                case 1:
                    criarComprador();
                    System.out.println("Você já está cadastrado. Por favor, faça login.");
                    break;
                case 2:
                    if (comprador != null) {
                        loggedIn = UX.fazerLogin(sc, comprador);
                    } else {
                        System.out.println("Você ainda não está cadastrado. Por favor, cadastre-se primeiro.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public static void telaDeCompra(){
        int categoria;
        boolean choice = true;
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("           MENU DE COMPRAS");
        System.out.print("[1] Livros\n[2] Eletrônicos\n[0] Sair\n>>");
        categoria = sc.nextInt();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        switch (categoria) {
            case 0:
                choice = false;
                break;
            case 1:
                System.out.println("Livros:");
                comprador.fazerCompra(categoria);
                break;
            case 2:
                System.out.println("Eletrônicos:");
                comprador.fazerCompra(categoria);
                break;
            default:
                System.out.println("Categoria inválida.");
                break;
        }

        if(categoria != 0) {
            System.out.print("Continuar busca? [S/N] \n>> ");
            sc.nextLine();
            choice = sc.nextLine().equalsIgnoreCase("s");
        }
        if(choice) {
            telaDeCompra();
        }else{
            System.out.println("Indo para o carrinho de compras...\n\n");
            comprador.finalizarCompra(carrinho);
        }
    }

    public static void limparTela() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    
}