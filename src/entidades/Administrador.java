package entidades;
import estoque.GerenciadorProdutos;

public class Administrador extends Usuario {
    private String cargo;

    public Administrador(String nome, String email, String senha, String cargo){
        super(nome, email, senha);
        this.cargo = "Gerente";
    }

    
    
}
