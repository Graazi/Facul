public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public void insert(T data) {
        if (root == null) {
            root = new TreeNode<>(data);
        } else {
            root.insert(data);
        }
    }

    public T search(T data) {
        if (root != null) {
            return root.search(data);
        }
        return null;
    }

    public void inOrderTraversal() {
        if (root != null) {
            root.inOrderTraversal();
        }
    }

    public void remove(Livro livro) {
    }
}
