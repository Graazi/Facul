public class LDENode{
    private char info;
    private LDENode prox;
    private LDENode ant;
    public LDENode next;
    public LDENode prev;
    public int rg;
    public String nome;
    public int value;

    public LDENode(int valor) {
        this.info = (char) valor;
    }

    public char getInfo() {
        return info;
    }

    public void setInfo(char info) {
        this.info = info;
    }

    public LDENode getProx() {
        return prox;
    }

    public void setProx(LDENode prox) {
        this.prox = prox;
    }

    public LDENode getAnt() {
        return ant;
    }

    public void setAnt(LDENode ant) {
        this.ant = ant;
    }
}
