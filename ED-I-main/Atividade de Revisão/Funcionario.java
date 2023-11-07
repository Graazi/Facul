
public class Funcionario implements Comparable <Funcionario> {
    private String matricula;
    private String nome;
    private String cargo;
    private double salario;
    private int anocontrato;

    public Funcionario (String matricula) {
        this.matricula = matricula;
    }   
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public int getAnocontrato() {
        return anocontrato;
    }
    public void setAnocontrato(int anocontrato) {
        this.anocontrato = anocontrato;
    }
    public String toString () {
        return this.matricula + " " + this.nome + " " + this.cargo + " R$" + this.salario + " " + this.anocontrato;
    }
    @Override
    public int compareTo(Funcionario f) {
        int result;
        result = this.matricula.compareTo(f.matricula);
        return result;
    }
    public void aplicarAumento (double percentual) {
        this.salario = this.salario + this.salario * percentual / 100;
    }
    public void setAno(int ano) {
    }
}
    
