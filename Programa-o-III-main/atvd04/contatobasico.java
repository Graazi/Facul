package atvd04;

public class contatobasico {
    
    private String nome;
    private String telefones;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefones() {
        return telefones;
    }
    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public String getDadoString() {
        return "Nome: " + nome + ", Telefones: " + telefones; 
    }
    
    public void setDados(String nome, String telefones) {
        this.nome = nome; 
        this.telefones = telefones;
    }
}
