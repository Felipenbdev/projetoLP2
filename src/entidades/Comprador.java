package entidades;

import estoque.Eletronico;
import estoque.GerenciadorProdutos;
import estoque.Livro;
import estoque.Produto;
import pagamento.Boleto;
import pagamento.CartaoCredito;
import pagamento.Pagamento;
import pagamento.Pix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Comprador extends Usuario {
    // Gerenciador de produtos estático
    public static GerenciadorProdutos gerenciador = new GerenciadorProdutos();

    // Construtor padrão
    public Comprador() {
    }

    // Construtor com parâmetros
    public Comprador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    // Método de autenticação
    @Override
    public boolean autenticacao(String email, String senha){
        if(this.email != null && this.senha != null) {
            if (this.email.equals(email) && this.senha.equals(senha)) {
                fazerLogin();
                return true;
            } else {
                System.out.println("Senha ou email inválido.");
                return false;
            }
        }
        System.out.println("Usuario nao encontrado, realize o registro!");
        return false;
    }

    public void fazerCompra(int categoria) {
        List<Produto> produtosEncontrados = new ArrayList<>();
        List<Produto> produtos = gerenciador.getProdutos();

        // Exibe produtos conforme a categoria escolhida
        for (Produto produto : produtos) {
            switch (categoria) {
                case 1:
                    if (produto instanceof Livro && produto.getQuantidade()>0) {
                        System.out.println(produto);
                    }
                    break;
                case 2:
                    if (produto instanceof Eletronico && produto.getQuantidade()>0) {
                        System.out.println(produto);
                    }
                    break;
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\nDigite o nome do produto que deseja comprar ou 'VOLTAR' para retroceder: ");
        String nomeProduto = sc.nextLine();

        // Opção para voltar ao menu de compras
        if (nomeProduto.equalsIgnoreCase("VOLTAR")) {
            System.out.println("Voltando ao menu de compras!");
            return;
        }

        // Busca pelo produto desejado
        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(nomeProduto.toLowerCase())) {
                if ((produto instanceof Livro && categoria == 1) || (produto instanceof Eletronico && categoria == 2)) {
                    if (produto.getQuantidade() > 0) {
                        produtosEncontrados.add(produto);
                    }
                }
            }
        }

        // Caso não encontre produtos
        if (produtosEncontrados.isEmpty()) {
            System.out.print("Não houve resultados na sua busca :( Deseja fazer outra busca? [s] para sim [n] para não: ");
            if (sc.nextLine().equalsIgnoreCase("s")) {
                return;
            }
            return;
        }

        // Lista os produtos encontrados
        int i = 1;
        for (Produto produto : produtosEncontrados) {
            System.out.printf("\n[%d] %s - quantidade: %d ", i, produto.getNome(), produto.getQuantidade());
            i++;
        }

        // Escolha do produto pelo índice
        System.out.print("\n[0] Sair\n Digite o indice --> ");
        int escolha = sc.nextInt();
        sc.nextLine(); // Consome a nova linha

        // Opção para sair
        if (escolha == 0) {
            System.out.println("Saindo! ");
        } else {
            finalizarCompra(produtosEncontrados.get(escolha - 1), sc);
        }
    }


    public void finalizarCompra(Produto produto, Scanner sc) {
        System.out.print("Digite a quantidade de produtos que deseja comprar: ");
        int quantidade = sc.nextInt();

        // Verifica se a quantidade é válida
        if (quantidade <= produto.getQuantidade() && quantidade > 0) {
            double preco = produto.getValor() * quantidade;
            System.out.println("Valor total: R$ " + preco);

            // Seleciona o método de pagamento
            Pagamento pagamento = selecionarMetodoPagamento(sc);
            if (pagamento != null) {
                pagamento.realizarPagamento(preco);
                produto.diminuirQuantidade(quantidade);
                System.out.println("Compra finalizada com sucesso!");
            } else {
                System.out.println("Método de pagamento inválido. Compra não realizada.");
            }
        } else {
            System.out.println("Quantidade inválida! Digite novamente.");
            finalizarCompra(produto, sc);
        }
    }

    private Pagamento selecionarMetodoPagamento(Scanner sc) {
        System.out.println("Selecione o método de pagamento:");
        System.out.println("[1] Cartão de Crédito");
        System.out.println("[2] Boleto");
        System.out.println("[3] Pix");
        System.out.print("--> ");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                return new CartaoCredito();
            case 2:
                return new Boleto();
            case 3:
                return new Pix();
            default:
                return null;
        }
    }
}
