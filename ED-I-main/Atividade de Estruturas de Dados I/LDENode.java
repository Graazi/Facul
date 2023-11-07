class LDENode {
    String nome;
    int rg;
    LDENode prev;
    LDENode next;
    
    public LDENode(String nome, int rg) {
        this.nome = nome;
        this.rg = rg;
        this.prev = null;
        this.next = null;
    }
}