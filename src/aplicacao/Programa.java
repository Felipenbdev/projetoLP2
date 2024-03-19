package aplicacao;

import entidades.Usuario;
import entidades.Vendedor;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Fazer registro vendedor");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();


        Vendedor usuario1 = new Vendedor(nome,email,senha);
        usuario1.adicionarProduto();
    }
}
