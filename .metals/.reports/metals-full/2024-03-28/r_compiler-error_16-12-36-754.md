file://<WORKSPACE>/avl/AVLTree.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.1/scala3-library_3-3.3.1.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.10/scala-library-2.13.10.jar [exists ]
Options:



action parameters:
offset: 627
uri: file://<WORKSPACE>/avl/AVLTree.java
text:
```scala
package avl;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> raiz;

    public void inserir(T valor, AVLNode<Integer> raiz2) {
        raiz = inserirRecursivamente(raiz, valor);
    }

    private AVLNode<T> inserirRecursivamente(AVLNode<T> node, T valor) {
        if (node == null)
            return new AVLNode<>(valor);

        if (valor.compareTo(node.valor) < 0)
            node.esquerda = inserirRecursivamente(node.esquerda, valor);
        else if (valor.compareTo(node.valor) > 0)
            node.direita = in@@serirRecursivamente(node.direita, valor);
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os valores a serem inseridos na árvore (digite -1 para terminar):");
        while (true) {
            int valor = scanner.nextInt();
            if (valor == -1)
                break;
            tree.inserir(valor, tree.raiz);
        }

        scanner.close();

        System.out.println("\nPasseio em ordem:");
        tree.passeioEmOrdem();

        System.out.println("\n\nPasseio por nível:");
        tree.passeioPorNivel();
    }
}


```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.HoverProvider$.hover(HoverProvider.scala:34)
	scala.meta.internal.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:352)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator