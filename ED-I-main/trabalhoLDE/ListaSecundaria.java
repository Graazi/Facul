package trabalhoLDE;

public class ListaSecundaria {
    NodeSecundario primeiro;

    public ListaSecundaria() {
        this.primeiro = null;
    }

    public void inserir(Termo termo) {
        NodeSecundario newNode = new NodeSecundario(termo);
        
        if (primeiro == null) {
            primeiro = newNode;
        } else if (termo.getNome().compareToIgnoreCase(primeiro.termo.getNome()) < 0) {
            newNode.prox = primeiro;
            primeiro.ant = newNode;
            primeiro = newNode;
        } else {
            NodeSecundario atual = primeiro;
            
            while (atual.prox != null && termo.getNome().compareToIgnoreCase(atual.prox.termo.getNome()) > 0) {
                atual = atual.prox;
            }
            
            newNode.prox = atual.prox;
            if (atual.prox != null) {
                atual.prox.ant = newNode;
            }
            
            atual.prox = newNode;
            newNode.ant = atual;
        }
    }
    
    public void remover(Termo termo) {
        NodeSecundario atual = primeiro;
        
        while (atual != null && !atual.termo.getNome().equalsIgnoreCase(termo.getNome())) {
            atual = atual.prox;
        }
            atual = atual.prox;
        
        
        if (atual != null) {
            if (atual.ant != null) {
                atual.ant.prox = atual.prox;
            } else {
                primeiro = atual.prox;
            }
            
        }
    }
           
    public NodeSecundario buscar(String termoName) {
        NodeSecundario atual = primeiro;
        
        while (atual != null && !atual.termo.getNome().equalsIgnoreCase(termoName)) {
            atual = atual.prox;
        }
        
       return atual;
    }
    
   public void exibir() {
    NodeSecundario atual = primeiro;
     
       while (atual != null) {
            System.out.println("Nome: " + atual.termo.getNome());
            System.out.println("Definição: " + atual.termo.getDefinicao());
            System.out.println();
            atual = atual.prox;
        }
    }
}
       