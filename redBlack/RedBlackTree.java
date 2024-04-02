package redBlack;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree<T extends Comparable<T>> {
    private RedBlackNode<T> nil; //nó sentinela
    private RedBlackNode<T> root; //raiz

    public RedBlackTree() {
        nil = new RedBlackNode<>();
        nil.setColour('B');
        root = nil;
    }

    public void insert(int data) {
        RedBlackNode<T> newNode = new RedBlackNode<>();
        newNode.setData(data); //dado
        newNode.setLeft(nil); //esquerda
        newNode.setRight(nil); //direita
        newNode.setColour('R'); //cor

        RedBlackNode<T> parent = null;
        RedBlackNode<T> current = root;

        while (current != nil) {
            parent = current;
            if (newNode.getData() < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        newNode.setParent(parent);

        if (parent == null) {
            root = newNode;
        } else if (newNode.getData() < parent.getData()) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }

        insertFixup(newNode);
    }

    private void insertFixup(RedBlackNode<T> node) { //reorganizar o novo nó
        while (node.getParent().getColour() == 'R') {
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                RedBlackNode<T> uncle = node.getParent().getParent().getRight();
                if (uncle.getColour() == 'R') {
                    node.getParent().setColour('B');
                    uncle.setColour('B');
                    node.getParent().getParent().setColour('R');
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getRight()) {
                        node = node.getParent();
                        leftRotate(node);
                    }
                    node.getParent().setColour('B');
                    node.getParent().getParent().setColour('R');
                    rightRotate(node.getParent().getParent());
                }
            } else {
                RedBlackNode<T> uncle = node.getParent().getParent().getLeft();
                if (uncle.getColour() == 'R') {
                    node.getParent().setColour('B');
                    uncle.setColour('B');
                    node.getParent().getParent().setColour('R');
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getLeft()) {
                        node = node.getParent();
                        rightRotate(node);
                    }
                    node.getParent().setColour('B');
                    node.getParent().getParent().setColour('R');
                    leftRotate(node.getParent().getParent());
                }
            }
        }
        root.setColour('B');
    }

    private void leftRotate(RedBlackNode<T> x) {
        RedBlackNode<T> y = x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != nil) {
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            root = y;
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
    }

    private void rightRotate(RedBlackNode<T> y) {
        RedBlackNode<T> x = y.getLeft();
        y.setLeft(x.getRight());
        if (x.getRight() != nil) {
            x.getRight().setParent(y);
        }
        x.setParent(y.getParent());
        if (y.getParent() == null) {
            root = x;
        } else if (y == y.getParent().getRight()) {
            y.getParent().setRight(x);
        } else {
            y.getParent().setLeft(x);
        }
        x.setRight(y);
        y.setParent(x);
    }

    public void caminhamentoEmOrdem() {
        caminhamentoEmOrdem(root);
        System.out.println();
    }

    private void caminhamentoEmOrdem(RedBlackNode<T> node) {
        if (node != nil) {
            caminhamentoEmOrdem(node.getLeft());
            System.out.print(node.getData() + " ");
            caminhamentoEmOrdem(node.getRight());
        }
    }

    public void caminhamentoPorNivel() {
        if (root == nil) return;
        Queue<RedBlackNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            RedBlackNode<T> node = queue.poll();
            System.out.print(node.getData() + " ");
            if (node.getLeft() != nil) queue.offer(node.getLeft());
            if (node.getRight() != nil) queue.offer(node.getRight());
        }
        System.out.println();
    }
}

