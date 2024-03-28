package avl;

class AVLNode<T extends Comparable<T>> {
    T valor;
    AVLNode<T> esquerda, direita;
    int altura;

    AVLNode(T valor) {
        this.valor = valor;
        altura = 1;
    }
}

