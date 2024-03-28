package avl;

import java.util.ArrayDeque;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> raiz;

    public void inserir(T valor) {
        raiz = inserirRecursivamente(raiz, valor);
    }

    private AVLNode<T> inserirRecursivamente(AVLNode<T> node, T valor) {
        if (node == null)
            return new AVLNode<>(valor);

        if (valor.compareTo(node.valor) < 0)
            node.esquerda = inserirRecursivamente(node.esquerda, valor);
        else if (valor.compareTo(node.valor) > 0)
            node.direita = inserirRecursivamente(node.direita, valor);
        else // Valor já existe, não faz nada
            return node;

        node.altura = 1 + Math.max(getAltura(node.esquerda), getAltura(node.direita));

        int balance = getBalanceamento(node);

        // rotação
        // Esquerda Esquerda
        if (balance > 1 && valor.compareTo(node.esquerda.valor) < 0)
            return rotacaoDireita(node);
        // Direita Direita
        if (balance < -1 && valor.compareTo(node.direita.valor) > 0)
            return rotacaoEsquerda(node);
        // Esquerda Direita
        if (balance > 1 && valor.compareTo(node.esquerda.valor) > 0) {
            node.esquerda = rotacaoEsquerda(node.esquerda);
            return rotacaoDireita(node);
        }
        // Direita Esquerda
        if (balance < -1 && valor.compareTo(node.direita.valor) < 0) {
            node.direita = rotacaoDireita(node.direita);
            return rotacaoEsquerda(node);
        }

        return node;
    }

    private AVLNode<T> rotacaoDireita(AVLNode<T> y) {
        AVLNode<T> x = y.esquerda;
        AVLNode<T> T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(getAltura(y.esquerda), getAltura(y.direita)) + 1;
        x.altura = Math.max(getAltura(x.esquerda), getAltura(x.direita)) + 1;

        return x;
    }

    private AVLNode<T> rotacaoEsquerda(AVLNode<T> x) {
        AVLNode<T> y = x.direita;
        AVLNode<T> T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(getAltura(x.esquerda), getAltura(x.direita)) + 1;
        y.altura = Math.max(getAltura(y.esquerda), getAltura(y.direita)) + 1;

        return y;
    }

    private int getAltura(AVLNode<T> node) {
        if (node == null)
            return 0;
        return node.altura;
    }

    private int getBalanceamento(AVLNode<T> node) {
        if (node == null)
            return 0;
        return getAltura(node.esquerda) - getAltura(node.direita);
    }

    public void passeioEmOrdem() {
        passeioEmOrdemRecursivo(raiz);
    }

    private void passeioEmOrdemRecursivo(AVLNode<T> node) {
        if (node != null) {
            passeioEmOrdemRecursivo(node.esquerda);
            System.out.print(node.valor + " ");
            passeioEmOrdemRecursivo(node.direita);
        }
    }

    public void passeioPorNivel() {
        if (raiz == null)
            return;

        Queue<AVLNode<T>> fila = new ArrayDeque<>();
        fila.add(raiz);

        int nivel = 1;
        while (!fila.isEmpty()) {
            int tamanho = fila.size();
            System.out.print("Nível " + nivel + ": ");
            for (int i = 0; i < tamanho; i++) {
                AVLNode<T> node = fila.poll();
                System.out.print(node.valor + " ");
                if (node.esquerda != null)
                    fila.add(node.esquerda);
                if (node.direita != null)
                    fila.add(node.direita);
            }
            nivel++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.inserir(10);
        tree.inserir(20);
        tree.inserir(30);
        tree.inserir(40);
        tree.inserir(50);
        tree.inserir(25);

        System.out.println("Passeio em ordem:");
        tree.passeioEmOrdem();

        System.out.println("\n\nPasseio por nível:");
        tree.passeioPorNivel();
    }
}

