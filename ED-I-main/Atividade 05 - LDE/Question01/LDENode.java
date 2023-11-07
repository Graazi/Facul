public class LDENode {
    private LDENode prox;
    private LDENode ant;
    private Pessoas info;
    
    public LDENode(Pessoas info) {
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
    public Pessoas getInfo() {
        return info;
    }
    public void setInfo(Pessoas info) {
        this.info = info;
    }

    
}