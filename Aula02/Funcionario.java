public class Funcionario {  
    
    public static final double SALARIO_MINIMO = 1621.00;
    
    private String nome;
    private String cpf;
    private double salario;

     public abstract String getFuncao();
        
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        if(cpf.length() == 11){
            this.cpf = cpf;
        }
    }
    
    public double getSalario() {
        return salario;
    }
        
    public void setSalario(double salario) {
        updateSalario(salario);
    }

    public void setSalario(Double salario) {
        updateSalario(salario.doubleValue());
    }

    private void updateSalario(double salario) {
        if(salario > SALARIO_MINIMO){
            this.salario = salario;
        }
    }

}