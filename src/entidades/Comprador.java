package entidades;

import estoque.*;
import pagamento.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Comprador extends Pessoa {
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
    @Override
    public Produto fazerCompra(int categoria) {
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
        if (nomeProduto.equals("VOLTAR")) {
            System.out.println("Voltando ao menu de compras...");
            // Encerra o método
            fazerCompra(categoria);
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
                fazerCompra(categoria);
            }

            // Encerra o método
            return null;
        }

        // Lista os produtos encontrados
        int i = 1;
        for (Produto produto : produtosEncontrados) {
            System.out.printf("\n[%d] %s - quantidade: %d ", i, produto.getNome(), produto.getQuantidade());
            i++;
        }

        // Escolha do produto pelo índice
        System.out.print("\n[0] Sair\nDigite o indice --> ");
        int escolha = sc.nextInt();
        sc.nextLine(); // Consome a nova linha

        // Opção para sair
        if(escolha < 0 || produtosEncontrados.size() < escolha) {
            fazerCompra(categoria);
        }
        if (escolha == 0) {
            System.out.println("Saindo! ");
            return null;
        } else {
            // Confirmação do produto
            System.out.printf("\nProduto escolhido: %s - R$ %.2f\n", produtosEncontrados.get(escolha - 1).getNome(), produtosEncontrados.get(escolha - 1).getValor());
            System.out.println("Confirma o produto? [S/N]: ");
            String confirmacao = sc.nextLine();
            if (!confirmacao.equalsIgnoreCase("s")) {
                return fazerCompra(categoria);
            }
            System.out.print("Digite a quantidade de produtos que deseja comprar: ");
            int quantidade = sc.nextInt();
            Produto produtoEncontrado = produtosEncontrados.get(escolha - 1);

            // Verifica se a quantidade é válida
            if (quantidade <= produtosEncontrados.get(escolha - 1).getQuantidade() && quantidade > 0) {
                produtosEncontrados.get(escolha - 1).diminuirQuantidade(quantidade);
                produtoEncontrado.setQuantidade(quantidade);
                return produtoEncontrado;
            }else{
                System.out.println("Valor Invalido, Retornando...");
                return fazerCompra(categoria);
            }

        }
    }

    @Override
    public void finalizarCompra(Carrinho carrinho) {
        carrinho.mostrarProdutos();
        double preco = carrinho.calcularValorTotal();
        System.out.printf("Valor Total: R$ %.2f\n", preco);

        // Seleciona o método de pagamento
        ServicoPagamento servicoPagamento = selecionarMetodoPagamento();
        if (servicoPagamento != null) {
            // Exibe detalhes do pagamento
            servicoPagamento.exibirDetalhesPagamento(this.nome, preco);
            System.out.print("Deseja confirmar o pagamento? [S/N]: ");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            if (sc.nextLine().equalsIgnoreCase("s")) {
                servicoPagamento.realizarPagamento(this.nome, preco);
                System.out.println("Compra finalizada com sucesso!");
                carrinho.esvaziarProdutos();
            } else {
                System.out.println("Pagamento cancelado.");
            }
        } else {
            System.out.println("Método de pagamento inválido. Compra não realizada.");
        }
    }

    private ServicoPagamento selecionarMetodoPagamento() {
        Scanner sc = new Scanner(System.in);
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
