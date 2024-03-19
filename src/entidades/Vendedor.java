package entidades;

import java.util.Scanner;

public class Vendedor extends Usuario{

    public Vendedor() {
    }

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    //métodos

    public void adicionarProduto() {
        Scanner sc = new Scanner(System.in);

        if(isLogin()) {
            System.out.println("Adicionar novo produto");
            System.out.print("Nome do Produto: ");
            String nome = sc.nextLine();
            System.out.print("Valor do Produto: ");
            double valor = sc.nextDouble();
            System.out.print("Quantidade do Produto: ");
            int quantidade = sc.nextInt();

            Produto produto = new Produto(nome, valor, quantidade);
        } else{
            System.out.println("Você precisa está logado na conta vendedor.");
        }
        sc.close();
    }
}
