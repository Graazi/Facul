public class LDEChar {
    
    private int qtd;
    private LDENode primeiro;
    private LDENode ultimo;

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

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

    public void preencherCom(String frase) {
        int tam = frase.length();

        for (int i = 0; i < tam; i++) {
            LDENode novo = new LDENode(frase.charAt(i));
            if (isEmpty()) {
                this.primeiro = novo;
                this.ultimo = novo;
                this.qtd++;
            }
            else{
                novo.setAnt(this.ultimo);
                this.ultimo.setProx(novo);
                this.ultimo = novo;
                this.qtd++;
            }

        }
    }

    public LDEChar criarCopiaInvertida (){

        LDENode aux=this.ultimo;
        LDEChar listaInvertida = new LDEChar();

        while (aux != null){
            listaInvertida.inserirFinal(aux.getInfo());
            aux= aux.getAnt();
        }
    return listaInvertida;
    }

    public char[] listaToVetor(){
        char[] vetor = new char[this.qtd];
        LDENode aux = this.primeiro;
        int i=0;

        while(aux !=null){
            vetor[i] = aux.getInfo();
            aux=aux.getProx();
            i++;
        }
        return vetor;
    }

    public void exibir() {
        if (isEmpty()) {
            System.out.println("A lista esta vazia");
        } else {
            LDENode aux = this.primeiro;
            while (aux != null) {
                System.out.println("elemento da lista " + aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    private void inserirFinal (char info){
        LDENode novo = new LDENode(info);
        if (isEmpty()) {
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd++;
        }
        else{
            novo.setAnt(this.ultimo);
            this.ultimo.setProx(novo);
            this.ultimo = novo;
            this.qtd++;
        }


    }

    private boolean isEmpty(){
        if (this.primeiro == null && this.ultimo == null && qtd == 0) {
            return true;
        } else {
            return false;
        }
    }
}
