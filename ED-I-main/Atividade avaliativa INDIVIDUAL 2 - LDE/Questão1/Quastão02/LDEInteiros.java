public class LDEInteiros {
    private LDENode primeiro;
    private LDENode ultimo;
    private int qtd;

    public LDENode getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(LDENode primeiro) {
        this.primeiro = primeiro;
    }

    public LDENode getUltimo() {
        return ultimo;
    }

    public void setUltimo(LDENode ultimo) {
        this.ultimo = ultimo;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void inserirLista (Integer valor) {
        LDENode novo = new LDENode (valor); 
        lista1 = lista1.juntar (lista2);
           this.primeiro = novo;
           this.ultimo = novo;
           this.qtd++;   
    }
    
}
