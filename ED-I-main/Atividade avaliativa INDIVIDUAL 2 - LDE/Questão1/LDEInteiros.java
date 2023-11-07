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

    private boolean isEmpty(){
        if (this.primeiro == null && this.ultimo == null && qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void inserirOrdenadoDecrescente (int valor) {
        LDENode novo, atual, anterior;
        if (this.isEmpty() == true) {
            novo = new LDENode (valor);
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd = 1;
            System.out.println("Inserção efetuada.");
        }
        else { // lista não vazia
            if (valor == this.primeiro.getInfo()) {
            novo = new LDENode (valor);
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd++; 
                System.out.println("Valor repetido. Inserção efetuada.");
            }
            else if (valor < this.primeiro.getInfo()) { // inserir depois do primeiro
                novo = new LDENode (valor);
                this.ultimo.setProx(novo);
                novo.setAnt(this.ultimo);
                this.ultimo = novo;
                this.qtd++; 
                System.out.println("Inserção efetuada.");
            }
            else if (valor == this.ultimo.getInfo()) {
                novo = new LDENode (valor);
                this.ultimo.setProx(novo);
                novo.setAnt(this.ultimo);
                this.ultimo = novo;
                this.qtd++; 
                System.out.println("Valor repetido. Inserção efetuada.");
            }
            else if (valor > this.ultimo.getInfo()) { // inserir antes do último
                novo = new LDENode (valor);
                this.primeiro.setAnt(novo);
                novo.setProx(this.primeiro);
                this.primeiro = novo;
                this.qtd++;     
                System.out.println("Inserção efetuada.");
            }
            else { 
                atual = this.primeiro;
                while (atual != null) {
                    if (valor > atual.getInfo()) { 
                        novo = new LDENode (valor);
                        anterior = atual.getAnt();                       
                        anterior.setProx(novo);
                        novo.setAnt(anterior);
                        novo.setProx(atual);
                        atual.setAnt(novo);
                        this.qtd++;
                        System.out.println("Inserção efetuada.");
                        return;
                    }
                    else {
                        atual = atual.getProx();
                    }
                }
            }
        }
    }


}