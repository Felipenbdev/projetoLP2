package entidades;

import java.util.Scanner;

public class Comprador extends Usuario{

    public Comprador() {
    }

    public Comprador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public static Produto fazerCompra(String nomeProduto,Produto[] produtos) {
        Scanner sc = new Scanner(System.in);
        //mostrar uma forma de consultar o vetor de produtos sem passar ele como parametro da função
        for(Produto produto: produtos){
            if(produto.getNome().contains(nomeProduto)){
                System.out.println(produto);
                System.out.print("Confirma o produto? [s/n] \n>> ");
                if(sc.next().toLowerCase().charAt(0) == 's'){
                    return produto;
                }
            }
        }
        System.out.println("o produto que digitou nao existe ou esta fora de estoque no momento");
        return null; 
   }

}
