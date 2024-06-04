package entidades;

public interface Autenticacao {
    public boolean autenticacao(String email, String senha);

    void fazerLogin();

    void fazerLogout();
}
