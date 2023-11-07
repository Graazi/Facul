package trabalhoLDE;

public class NodeSecundario {
    Termo termo;
    NodeSecundario prox;
    NodeSecundario ant;

    public NodeSecundario(Termo termo) {
        this.termo = termo;
        this.prox = null;
        this.ant = null;
    
    }

    public Termo getTermo() {
        return termo;
    }

    public void setTermo(Termo termo) {
        this.termo = termo;
    }

    public NodeSecundario getProx() {
        return prox;
    }

    public void setProx(NodeSecundario prox) {
        this.prox = prox;
    }

    public NodeSecundario getAnt() {
        return ant;
    }

    public void setAnt(NodeSecundario ant) {
        this.ant = ant;
    }
}
