class NodePrincipal {
    char letra;
    ListaSecundaria listaSecundaria;
    NodePrincipal next;

    public NodePrincipal (char letra) {
        this.letra = letra;
        this.listaSecundaria = null;
        this.next = null;
    }
}
