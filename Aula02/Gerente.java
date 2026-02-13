public class Gerente extends Funcionario implements Autenticavel {
    
    private String senha;

    @Override
    public String getFuncao() {
        return "Gerente";
    }   
    @Override
    public boolean autenticar(String senha) {
        return this.senha == senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}