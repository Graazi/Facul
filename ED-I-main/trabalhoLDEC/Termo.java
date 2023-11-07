package trabalhoLDEC;

public class Termo {
    private String nome;
    private String definicao;

    public Termo(String nome, String definicao) {
        this.nome = nome;
        this.definicao = definicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDefinicao() {
        return definicao;
    }

    public void setDefinicao(String definicao) {
        this.definicao = definicao;
    }

}
