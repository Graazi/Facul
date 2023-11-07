package Question01.Question02;
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

    public static int findMinimumValue(TreeNode root) {
        TreeNode atual = root;
        while (atual.left != null) {
            atual = atual.left;
        }
    

        return atual.value;
    }
}
