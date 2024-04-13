package entidades;

public class Produto {
    protected String nome;
    protected double valor;
    protected int quantidade;
    protected boolean disponivel;


    public Produto(String nome, double valor, int quantidade) {
        super();
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        if(quantidade > 0){
            this.disponivel = true;
        }else{
            this.disponivel = false;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}
