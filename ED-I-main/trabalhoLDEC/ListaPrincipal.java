package trabalhoLDEC;

public class ListaPrincipal {
    NodePrincipal primeiro;

    public ListaPrincipal() {
        this.primeiro = null;
    }

    public void inserirTermo (String nome, String definicao) {
        Termo termo = new Termo(nome, definicao);
        char primeiraLetra = Character.toLowerCase(nome.charAt(0));

        ListaPrincipal listaPrincipal = buscarTermo(String nome);
        if ((listaPrincipal.primeiro, primeiraLetralistaPrincipal.isEmpty() || !letraExists)) {  
            listaPrincipal.inserirLetra(primeiraLetra);
            } else {  
                ListaSecundaria listaSecundaria = getListaSecundaria(listaPrincipal.primeiro, primeiraLetra);
            
            listaSecundaria.inserirTermo(termo);
            System.out.println("Termo cadastrado com sucesso.");
        }
    }

    public void inserirLetra(char letra) {
        NodePrincipal newNode = new NodePrincipal(letra);

        if (primeiro == null) {
            primeiro = newNode;
            primeiro.next = primeiro;
        } else {
            NodePrincipal atual = primeiro;
            while (atual.next != primeiro) {
                atual = atual.next;
            }
            atual.next = newNode;
            newNode.next = primeiro;
        }
    }
    
    public boolean isEmpty() {
        return primeiro == null;
    }

    public void exibirTermo() {
        if (isEmpty()) {
            System.out.println("Lista principal vazia.");
            return;
        }

        NodePrincipal atual = primeiro;
        do {
            System.out.print(atual.letra + " ");
            atual = atual.next;
        } while (atual != primeiro);
        System.out.println();
    }

    private static boolean letraExists(NodePrincipal primeiro, char letra) {
    NodePrincipal atual = primeiro;
    do {
        if (atual.letra == letra) {
            return true;
        }
        atual = atual.next;
    } while (atual != primeiro);
    return false;
}

    private static ListaSecundaria getListaSecundaria(NodePrincipal primeiro, char letra) {
    NodePrincipal atual = primeiro;
    do {
        if (atual.letra == letra) {
            if (atual.listaSecundaria == null) {
                atual.listaSecundaria = new ListaSecundaria();
            }
            return atual.listaSecundaria;
        }
        atual = atual.next;
    } while (atual != primeiro);
    return null;
}

    public ListaPrincipal buscarTermo (String nome) {
        ListaPrincipal listaPrincipal;

        boolean achou = false;
        ListaPrincipal atual = this.primeiro;
        while (listaPrincipal != null) {
            if (listaPrincipal.getNext().equals(nome) == null){
                achou = true;
                break;
            } 
            listaPrincipal = listaPrincipal.getNext();
        }
        if (achou == true) {
            return listaPrincipal; 
        } else {
            return null;
        }

    }

}
