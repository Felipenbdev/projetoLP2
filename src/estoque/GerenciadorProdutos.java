package estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GerenciadorProdutos implements ServicoProdutos {
    private static final List<Produto> produtos = new ArrayList<Produto>();

    public GerenciadorProdutos() {
        estocarProdutos();
    }

    public void estocarProdutos() {
        //livros
        produtos.add(new Livro("Harry Potter", 50.00, 10));
        produtos.add(new Livro("Senhor dos Aneis", 40.00, 10));
        produtos.add(new Livro("O Pequeno Principe", 30.00, 10));
        produtos.add(new Livro("Dom Casmurro", 20.00, 10));
        produtos.add(new Livro("Casa Monstro", 10.00, 10));
        //eletronicos
        produtos.add(new Eletronico("Iphone", 5000.00, 10));
        produtos.add(new Eletronico("Samsung", 4000.00, 10));
        produtos.add(new Eletronico("Motorola", 3000.00, 10));
        produtos.add(new Eletronico("Xiaomi", 2000.00, 10));
        produtos.add(new Eletronico("LG", 1000.00, 10));
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Produto> fazerBusca(String nomeProduto,int categoria){
        // Busca pelo produto desejado
        List<Produto> produtosEncontrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(nomeProduto.toLowerCase())) {
                if ((produto instanceof Livro && categoria == 1) || (produto instanceof Eletronico && categoria == 2)) {
                    if (produto.getQuantidade() > 0) {
                        produtosEncontrados.add(produto);
                    }
                }
            }
        }
        return produtosEncontrados;
    }

    @Override
    public void addProduto(Produto produto) {
        if (produto != null) {
            produtos.add(produto);
        }
    }

    @Override
    public void removerProduto(int index) {
        produtos.remove(index);
    }

    @Override
    public void mostrarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio!");
        } else {
            System.out.println("Estoque:");
            System.out.print("-----------------------------------");
            int i = 1;
            for (Produto produto : produtos) {
                System.out.printf("|-[%d]-|", i);
                System.out.print(produto);
                i++;
            }
        }
    }

    public void mostrarProdutos(int categoria) {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio!");
        } else {
            // Exibe produtos conforme a categoria escolhida
            for (Produto produto : produtos) {
                switch (categoria) {
                    case 1:
                        if (produto instanceof Livro && produto.getQuantidade() > 0) {
                            System.out.println(produto);
                        }
                        break;
                    case 2:
                        if (produto instanceof Eletronico && produto.getQuantidade() > 0) {
                            System.out.println(produto);
                        }
                        break;
                }
            }
        }
    }

    @Override
    public void esvaziarProdutos() {
        produtos.clear();
    }

    @Override
    public double calcularValorTotal() {
        double preco = 0;
        for (Produto produto : produtos) {
            preco += produto.getQuantidade() * produto.getValor();
        }
        return preco;
    }

    @Override
    public void editarProdutos() {
        Scanner sc = new Scanner(System.in);
        System.out.print("[1] para adcionar [2] para remover [3] para calcular valor do estoque e [0] para sair\n>>");
        int categoria = sc.nextInt();
        switch (categoria) {
            case 1:
                System.out.print("digite o nome do produto\n>>");
                sc.nextLine();
                String nome = sc.nextLine();
                System.out.print("digite o valor do produto\n>>");
                double valor = sc.nextDouble();
                System.out.print("digite a quantidade do produto\n>>");
                int quantidade = sc.nextInt();
                System.out.print("[1] para livro [2] para eletronico\n>>: ");
                categoria = sc.nextInt();
                if (categoria == 1) {
                    produtos.add(new Livro(nome, valor, quantidade));
                } else if (categoria == 2) {
                    produtos.add(new Eletronico(nome, valor, quantidade));
                } else {
                    System.out.println("Categoria invalida!");
                }
                break;
            case 2:
                if (produtos.isEmpty()) {
                    System.out.println("Estoque vazio!");
                } else {
                    mostrarProdutos();
                    System.out.print("Digite o indice para remover: ");
                    int i = sc.nextInt();
                    if(i < 0 || produtos.size() < i) {
                        System.out.println("Erro!");
                        editarProdutos();
                    }
                    removerProduto(i - 1);
                    System.out.println("Estoque atualizado!");
                    mostrarProdutos();
                }
                break;
            case 3:
                System.out.printf("Soma do estoque: %f\n", calcularValorTotal());
                break;
            default:
                System.out.println("Categoria invalida!");
        }
        System.out.print("Deseja editar mais uma vez? [s] [n]\n>>");
        sc.nextLine(); //buffer
        if (sc.nextLine().equalsIgnoreCase("s")) {
            editarProdutos();
        } else {
            System.out.println("Encerrando edição...");
        }
    }
}