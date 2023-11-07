public class LDEPessoas {
    private int qtd;
    private int RG;
    private LDENode primeiro;
    private LDENode ultimo;
    
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public int getRG() {
        return RG;
    }
    public void setRG(int rG) {
        RG = rG;
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

    public LDEPessoas exibirInvertida (){

        LDENode aux=this.ultimo;
        LDEPessoas listaInvertida = new LDEPessoas();

        while (aux != null){
            listaInvertida.inserirFinal(aux.getInfo());
            aux= aux.getAnt();
        }
    return listaInvertida;
    }


    private void inserirFinal (char c){
        LDENode novo = new LDENode(c);
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
    public void cadastrarPessoa(String nome, int rg2) {
    }
    public void cancelarCadastro(int rg2) {
    }
    public void exibirPessoas() {
    }
    public void exibirPessoasInverso() {
    }
    public boolean verificarPessoa(int rg2) {
        return false;
    }
    public String quantidadePessoas() {
        return null;
    }
    public void removerPessoa(int rg2) {
    }
}