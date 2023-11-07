package trabalhoLDE;

public class NodePrincipal {
    ListaSecundaria listaSecundaria;
    NodePrincipal prox;
    NodePrincipal ant;
    char letra;

    public NodePrincipal (char letra) {
        this.letra = letra;
        this.listaSecundaria = new ListaSecundaria();
        this.prox = null;
        this.ant = null;
    }

    public ListaSecundaria getListaSecundaria() {
        return listaSecundaria;
    }

    public void setListaSecundaria(ListaSecundaria listaSecundaria) {
        this.listaSecundaria = listaSecundaria;
    }

    public NodePrincipal getProx() {
        return prox;
    }

    public void setProx(NodePrincipal prox) {
        this.prox = prox;
    }

    public NodePrincipal getAnt() {
        return ant;
    }

    public void setAnt(NodePrincipal ant) {
        this.ant = ant;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }
}
