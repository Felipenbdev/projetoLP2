package entidades;

public class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    protected boolean login;

    public Usuario(){

    }
    public Usuario(String nome, String email, String senha) {
        super();
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
    public boolean autenticacao(String email, String senha) {
        if (this.email.equals(email) && this.senha.equals(senha)) {
            fazerLogin();
            return true;
        } else {
            System.out.println("Senha ou email inválido.");
            return false;
        }
    }

    public boolean fazerLogin() {
        setLogin(true);
        return this.login;
    }

    public void fazerLogout() {
        setLogin(false);
    }


}
