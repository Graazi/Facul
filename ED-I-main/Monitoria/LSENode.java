package Monitoria;

public class LSENode {
    private Integer info;
    private LSENode prox;
    
    public Integer getInfo() {
        return info;
    }
    public void setInfo(Integer info) {
        this.info = info;
    }
    public LSENode getProx() {
        return prox;
    }
    public void setProx(LSENode prox) {
        this.prox = prox;
    }
    
}