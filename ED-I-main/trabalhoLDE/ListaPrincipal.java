package trabalhoLDE;

public class ListaPrincipal {
    NodePrincipal primeiro;

    public ListaPrincipal() {
        this.primeiro = null;
    }

    public void inserir(char letra) {
        NodePrincipal newNode = new NodePrincipal(letra);
        
        if (primeiro == null) {
            primeiro = newNode;
        } else if (letra < primeiro.letra) {
            newNode.prox = primeiro;
            primeiro.ant = newNode;
            primeiro = newNode;
        } else {
            NodePrincipal atual = primeiro;
            
            while (atual.prox != null && atual.prox.letra < letra) {
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
    
    public void remover(char letra) {
        NodePrincipal atual = primeiro;
        
        while (atual != null && atual.letra != letra) {
            atual = atual.prox;
        }
        
        if (atual != null) {
            if (atual.ant != null) {
                atual.ant.prox = atual.prox;
            } else {
                primeiro = atual.prox;
            }
            
            if (atual.prox != null) {
                atual.prox.ant = atual.ant;
            }
        }
    }
    
    public NodePrincipal buscar(char letra) {
        NodePrincipal atual = primeiro;
        
        while (atual != null && atual.letra != letra) {
            atual = atual.prox;
        }
        
        return atual;
    }
    
    public void exibir() {
        NodePrincipal atual = primeiro;
        
        while (atual != null) {
            System.out.print(atual.letra + " ");
            atual = atual.prox;
        }
        
        System.out.println();
    }
}