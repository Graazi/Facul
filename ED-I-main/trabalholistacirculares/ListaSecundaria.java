class ListaSecundaria {
    NodeSecundario head;

    public ListaSecundaria() {
        this.head = null;
    }

    public void inserirTermo (Termo termo) {
        NodeSecundario newNode = new NodeSecundario(termo);

        if (head == null) {
            head = newNode;
        } else {
            if (termo.getNome().compareTo(head.termo.getNome()) < 0) {
                newNode.next = head;
                head = newNode;
            } else {
                NodeSecundario atual = head;
                while (atual.next != null && termo.getNome().compareTo(atual.next.termo.getNome()) > 0) {
                    atual = atual.next;
                }
                newNode.next = atual.next;
                atual.next = newNode;
            }
        }
    }

    public void removerTermo(String nome) {
        if (head == null) {
            return;
        }

        if (head.termo.getNome().equals(nome)) {
            head = head.next;
            return;
        }

        NodeSecundario atual = head;
        NodeSecundario prev = null;
        while (atual != null && !atual.termo.getNome().equals(nome)) {
            prev = atual;
            atual = atual.next;
        }

        if (atual != null) {
            prev.next = atual.next;
        }
    }

   
    public boolean isEmpty() {
        return head == null;
    }

    public void exibirTermo() {
        if (isEmpty()) {
            System.out.println("Lista secundária vazia.");
            return;
        }

        NodeSecundario atual = head;
        while (atual != null) {
            System.out.println("Nome: " + atual.termo.getNome());
            System.out.println("Definição: " + atual.termo.getDefinicao());
            atual = atual.next;
        }
    }

    public Termo buscarTermo(String nome) {
        NodeSecundario atual = head;
        while (atual != null) {
            if (atual.termo.getNome().equals(nome)) {
                return atual.termo;
            }
            atual = atual.next;
        }
        return null;
    }
}