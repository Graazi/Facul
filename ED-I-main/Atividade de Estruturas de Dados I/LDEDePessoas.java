class LDEDePessoas {
    LDENode head;
    LDENode tail;
    int count;
    
    public LDEDePessoas() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }
    
    public void cadastrarPessoa(String nome, int rg) {
        LDENode newNode = new LDENode(rg);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
        System.out.println("Pessoa cadastrada com sucesso!");
    }
    
    public void cancelarCadastro(int rg) {
        LDENode current = head;
        while (current != null) {
            if (current.rg == rg) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                count--;
                System.out.println("Registro cancelado com sucesso!");
                return;
            }
            current = current.next;
        }
        System.out.println("RG não encontrado. Registro não cancelado.");
    }
    
    public void exibirPessoas() {
        LDENode current = head;
        if (current == null) {
            System.out.println("Não há pessoas no prédio.");
        } else {
            System.out.println("Pessoas no prédio:");
            while (current != null) {
                System.out.println("Nome: " + current.nome + ", RG: " + current.rg);
                current = current.next;
            }
        }
    }
    
    public void exibirPessoasInverso() {
        LDENode current = tail;
        if (current == null) {
            System.out.println("Não há pessoas no prédio.");
        } else {
            System.out.println("Pessoas no prédio (ordem inversa):");
            while (current != null) {
                System.out.println("Nome: " + current.nome + ", RG: " + current.rg);
                current = current.prev;
            }
        }
    }
    
    public boolean verificarPessoa(int rg) {
        LDENode current = head;
        while (current != null) {
            if (current.rg == rg) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public int quantidadePessoas() {
        return count;
    }
    
    public void removerPessoa(int rg) {
        LDENode current = head;
        while (current != null) {
            if (current.rg == rg) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                count--;
                System.out.println("Pessoa removida com sucesso!");
                return;
            }
            current = current.next;
        }
        System.out.println("RG não encontrado. Pessoa não removida.");
    }
}