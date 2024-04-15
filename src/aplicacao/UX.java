package aplicacao;

import entidades.Comprador;
import java.util.Scanner;

import static aplicacao.Programa.comprador;
import static entidades.Comprador.gerenciador;

public class UX {
    private static Scanner sc = new Scanner(System.in);
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
        int categoria = 0;
        // Loop para comprar produtos
        boolean continuarComprando = true;
        while (continuarComprando) {
            do{
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("           MENU DE COMPRAS");
                System.out.print("[1] Bebidas\n[2] Livros\n[3] Eletrônicos\n[4] Roupas\n[5] Alimentos\n[0] Sair\n>>");
                categoria = sc.nextInt();

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
                        sc.nextLine(); // Limpa o buffer de entrada
                        System.out.print("Digite o nome do produto que deseja comprar: ");
                        comprador.fazerCompra(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Livros:");
                        for(int i = 0; i < 5; i++) {
                            System.out.println(gerenciador.getProdutos(1, i));
                        }
                        sc.nextLine(); // Limpa o buffer de entrada
                        System.out.print("Digite o nome do produto que deseja comprar: ");
                        comprador.fazerCompra(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("Eletrônicos:");
                        for(int i = 0; i < 5; i++) {
                            System.out.println(gerenciador.getProdutos(2, i));
                        }
                        sc.nextLine(); // Limpa o buffer de entrada
                        System.out.print("Digite o nome do produto que deseja comprar: ");
                        comprador.fazerCompra(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Roupas:");
                        for(int i = 0; i < 5; i++) {
                            System.out.println(gerenciador.getProdutos(3, i));
                        }
                        sc.nextLine(); // Limpa o buffer de entrada
                        System.out.print("Digite o nome do produto que deseja comprar: ");
                        comprador.fazerCompra(sc.nextLine());
                        break;
                    case 5:
                        System.out.println("Alimentos:");
                        for(int i = 0; i < 5; i++) {
                            System.out.println( gerenciador.getProdutos(4, i));
                        }
                        sc.nextLine(); // Limpa o buffer de entrada
                        System.out.print("Digite o nome do produto que deseja comprar: ");
                        comprador.fazerCompra(sc.nextLine());
                        break;
                    default:
                        System.out.println("Categoria inválida.");
                        break;
                }
            }while(categoria != 0);
            if(categoria != 0) {

                System.out.print("Deseja continuar comprando? [s/n] \n>> ");
                continuarComprando = sc.next().toLowerCase().charAt(0) == 's';
                sc.nextLine(); // Limpa o buffer de entrada
            }
        }
    }
    public static void limparTela(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
