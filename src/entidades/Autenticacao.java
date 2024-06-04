package entidades;

public interface Autenticacao {
    public abstract boolean autenticacao(String email, String senha);

    void fazerLogin();

    void fazerLogout();
}
