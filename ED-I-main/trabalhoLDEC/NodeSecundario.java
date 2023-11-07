package trabalhoLDEC;

public class NodeSecundario {
    Termo termo;
    NodeSecundario next;

    public NodeSecundario(Termo termo) {
        this.termo = termo;
        this.next = null;
    
    }

    public Termo getTermo() {
        return termo;
    }

    public void setTermo(Termo termo) {
        this.termo = termo;
    }

    public NodeSecundario getNext() {
        return next;
    }

    public void setNext(NodeSecundario next) {
        this.next = next;
    }
}
