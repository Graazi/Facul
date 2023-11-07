import trabalholistaLDE.NodePrincipal;

class ListaPrincipal {
    NodePrincipal head;

    public ListaPrincipal() {
        this.head = null;
    }


    public void inserirLetra(char letra) {
        NodePrincipal newNode = new NodePrincipal(letra);

        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            NodePrincipal atual = head;
            while (atual.next != head) {
                atual = atual.next;
            }
            atual.next = newNode;
            newNode.next = head;
        }
    }
    
    public boolean isEmpty() {
        return head == null;
    }

    public void exibirTermo() {
        if (isEmpty()) {
            System.out.println("Lista principal vazia.");
            return;
        }

        NodePrincipal atual = head;
        do {
            System.out.print(atual.letra + " ");
            atual = atual.next;
        } while (atual != head);
        System.out.println();
    }
}


