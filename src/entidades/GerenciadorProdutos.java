package entidades;

public class GerenciadorProdutos{
        private Produto [][] produtos= new Produto[5][5];
    private GerenciadorProdutos(Produto produtos[][]) {
        this.produtos = produtos;
    }
    public void addProdutos(Produto produtos[][]) {
        //bebidas
        produtos [0][0] = new Produto("Coca-Cola", 5.00, 10);
        produtos [0][1] = new Produto("Pepsi", 4.00, 10);
        produtos [0][2] = new Produto("Fanta", 3.00, 10);
        produtos [0][3] = new Produto("Guarana", 2.00, 10);
        produtos [0][4] = new Produto("Sprite", 1.00, 10);
        //livros
        produtos [1][0] = new Produto("Harry Potter", 50.00, 10);
        produtos [1][1] = new Produto("Senhor dos Aneis", 40.00, 10);
        produtos [1][2] = new Produto("O Pequeno Principe", 30.00, 10);
        produtos [1][3] = new Produto("Dom Casmurro", 20.00, 10);
        produtos [1][4] = new Produto("O Cortiço", 10.00, 10);
        //eletronicos
        produtos [2][0] = new Produto("Iphone", 5000.00, 10);
        produtos [2][1] = new Produto("Samsung", 4000.00, 10);
        produtos [2][2] = new Produto("Motorola", 3000.00, 10);
        produtos [2][3] = new Produto("Xiaomi", 2000.00, 10);
        produtos [2][4] = new Produto("LG", 1000.00, 10);
        //roupas
        produtos [3][0] = new Produto("Camisa", 50.00, 10);
        produtos [3][1] = new Produto("Calça", 40.00, 10);
        produtos [3][2] = new Produto("Bermuda", 30.00, 10);
        produtos [3][3] = new Produto("Blusa", 20.00, 10);
        produtos [3][4] = new Produto("Vestido", 10.00, 10);
        //alimentos
        produtos [4][0] = new Produto("Arroz", 5.00, 10);
        produtos [4][1] = new Produto("Feijão", 4.00, 10);
        produtos [4][2] = new Produto("Macarrão", 3.00, 10);
        produtos [4][3] = new Produto("Carne", 2.00, 10);
        produtos [4][4] = new Produto("Frango", 1.00, 10);
        }
    public Produto getProdutos(Produto produtos[][], int linha, int coluna) {
        return produtos[linha][coluna];
    }
   
    


    

    

 
}
