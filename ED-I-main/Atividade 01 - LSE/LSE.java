public class LSE {
    private LSENode primeiro;
    
    public void inserir (Funcionario f) {
        LSENode novo;
        novo = new LSENode ();    
        novo.setInfo(f);          
        
        if (this.primeiro == null) {    
             this.primeiro = novo;
        }
        else {
            novo.setProx(this.primeiro);
            this.primeiro = novo;
        }
    }
    public void exibir() {
        LSENode atual = primeiro;
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getProx();
        }
    }
}

