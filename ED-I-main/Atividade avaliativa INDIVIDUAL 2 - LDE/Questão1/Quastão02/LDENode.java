public class LDENode {
    private LDENode ant;
    private Integer info;
    private LDENode prox;
    
    public LDENode (Integer valor) {
        this.info = valor;
    }

    public LDENode getAnt() {
        return this.ant;
    }

    public void setAnt(LDENode ant) {
        this.ant = ant;
    }

    public Integer getInfo() {
        return this.info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public LDENode getProx() {
        return this.prox;
    }

    public void setProx(LDENode prox) {
        this.prox = prox;
    }

    
}
