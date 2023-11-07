package atvd04;

public class econtato {
    
    private String email;
    private String homepage;
    private String nome;
    
    public String getEmail() {
        return email;
    }
    public String getHomepage() {
        return homepage;
    }
    public String getDados() {
        return "Nome: " + nome + ", Email: " + email + ", Homepage: " + homepage;
    }
    
    
}
