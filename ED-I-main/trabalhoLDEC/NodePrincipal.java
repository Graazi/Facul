package trabalhoLDEC;

public class NodePrincipal {
    char letra;
    ListaSecundaria listaSecundaria;
    NodePrincipal next;

    public NodePrincipal (char letra) {
        this.letra = letra;
        this.listaSecundaria = new ListaSecundaria();
        this.next = null;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public ListaSecundaria getListaSecundaria() {
        return listaSecundaria;
    }

    public void setListaSecundaria(ListaSecundaria listaSecundaria) {
        this.listaSecundaria = listaSecundaria;
    }

    public NodePrincipal getNext() {
        return next;
    }

    public void setNext(NodePrincipal next) {
        this.next = next;
    }
    
}
