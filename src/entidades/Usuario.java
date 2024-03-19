package entidades;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private boolean login;

    public Usuario(){

    }
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.login = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
    // métodos

    public boolean fazerLogin() {
        setLogin(true);
        return this.login;
    }

    public boolean fazerLogout() {
        setLogin(false);
        return this.login;
    }


}
