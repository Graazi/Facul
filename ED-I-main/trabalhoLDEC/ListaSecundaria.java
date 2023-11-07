package trabalhoLDEC;

public class ListaSecundaria {
    
    NodeSecundario primeiro;

    public ListaSecundaria() {
        this.primeiro = null;
    }

    public void inserirTermo (Termo termo) {
        NodeSecundario newNode = new NodeSecundario(termo);

        if (primeiro == null) {
            primeiro = newNode;
        } else {
            if (termo.getNome().compareTo(primeiro.termo.getNome()) < 0) {
                newNode.next = primeiro;
                primeiro = newNode;
            } else {
                NodeSecundario atual = primeiro;
                while (atual.next != null && termo.getNome().compareTo(atual.next.termo.getNome()) > 0) {
                    atual = atual.next;
                }
                newNode.next = atual.next;
                atual.next = newNode;
            }
        }
    }

    public void removerTermo(String nome) {
        if (primeiro == null) {
            return;
        }

        if (primeiro.termo.getNome().equals(nome)) {
            primeiro = primeiro.next;
            return;
        }

        NodeSecundario atual = primeiro;
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
        return primeiro == null;
    }

    public void exibirTermo() {
        if (isEmpty()) {
            System.out.println("Lista secundária vazia.");
            return;
        }

        NodeSecundario atual = primeiro;
        while (atual != null) {
            System.out.println("Nome: " + atual.termo.getNome());
            System.out.println("Definição: " + atual.termo.getDefinicao());
            atual = atual.next;
        }
    }

    public Termo buscarTermo(String nome) {
        NodeSecundario atual = primeiro;
        while (atual != null) {
            if (atual.termo.getNome().equals(nome)) {
                return atual.termo;
            }
            atual = atual.next;
        }
        return null;
    }
}