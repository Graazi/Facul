package Question01;
class BinaryTree<T extends Comparable<T>> {
    TreeNode <T> root;
    
    public BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    public int countfolhas(T value) {
            int cont = 0;
            TreeNode<T> aux;
            if (this.isEmpty() == true) {
                return cont;
            } else {
                aux = this.root;
                while (aux != null) {
                    int compara = value.compareTo(aux.getInfo());
                    if (compara == 0) {
                        cont++;
                        aux = aux.getRight();
                    } else if (compara < 0) {
                        aux = aux.getLeft();
                    } else {
                        aux = aux.getRight();
                    }
                }
                return cont;
            }
        }

}
