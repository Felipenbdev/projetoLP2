package entidades;

public interface ServicoUsuario {
    public boolean autenticacao(String email, String senha);

    void fazerLogin();

    void fazerLogout();
}
