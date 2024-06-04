package aplicacao;

import entidades.Comprador;
import estoque.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static aplicacao.Programa.comprador;

public class UX {
    private static final Scanner sc = new Scanner(System.in); // Scanner para entrada de dados do usuário

    private static final List<Produto> carrinho = new ArrayList<>();
    // Método para criar um novo comprador
    public static void criarComprador() {
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        // Define os dados do comprador
        comprador.setEmail(email);
        comprador.setNome(nome);
        comprador.setSenha(senha);
    }

    // Método para realizar login
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
        UX.menuLogin();
        int ops = sc.nextInt();
        sc.nextLine();

        switch (ops) {
            case 1:
                criarComprador();
                System.out.println("Você já está cadastrado. Por favor, faça login.");
                telaDeLogin(); // Chama recursivamente até uma opção válida ser escolhida
                break;
            case 2:
                if (comprador != null) {
                    boolean loggedIn = UX.fazerLogin(sc, comprador);
                    if (!loggedIn) {
                        System.out.println("Login falhou. Tente novamente.");
                        telaDeLogin(); // Chama recursivamente até o login ser bem-sucedido
                    }
                } else {
                    System.out.println("Você ainda não está cadastrado. Por favor, cadastre-se primeiro.");
                }
                break;
            default:
                System.out.println("Opção inválida.");
                telaDeLogin(); // Chama recursivamente até uma opção válida ser escolhida
                break;
        }
    }

    // Tela de compra
    public static void telaDeCompra(){
        Produto produtoEncontrado;
        int categoria;
        boolean choice = true;
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("           MENU DE COMPRAS");
        System.out.print("[1] Livros\n[2] Eletrônicos\n[0] Sair\n>>");
        categoria = sc.nextInt();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        // Switch para escolher a categoria
        switch (categoria) {
            case 0:
                choice = false;
                break;
            case 1:
                System.out.println("Livros:");
                produtoEncontrado = comprador.fazerCompra(categoria);
                if(produtoEncontrado != null) {
                    carrinho.add(produtoEncontrado);
                }
                break;
            case 2:
                System.out.println("Eletrônicos:");
                produtoEncontrado = comprador.fazerCompra(categoria);
                if(produtoEncontrado != null) {
                    carrinho.add(produtoEncontrado);
                }
                break;
            default:
                System.out.println("Categoria inválida.");
                break;
        }

        // Pergunta se o usuário deseja continuar comprando
        if(categoria != 0) {
            System.out.print("Deseja continuar comprando? [s/n] \n>> ");
            sc.nextLine();
            choice = sc.nextLine().equalsIgnoreCase("s");
        }
        if(choice) {
            telaDeCompra(); // Chama recursivamente para continuar comprando
        } else {
            System.out.println("Saindo");
            comprador.finalizarCompra(carrinho);
        }
    }

    // Método para limpar a tela (simula a limpeza da tela do console)
    public static void limparTela() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
