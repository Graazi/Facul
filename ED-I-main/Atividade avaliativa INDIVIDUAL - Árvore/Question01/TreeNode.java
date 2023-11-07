package Question01;
class TreeNode<T extends Comparable<T>> { 

    private T info;
    private TreeNode<T> left;
    private TreeNode<T> right;

    TreeNode(T info) {
        this.info = info;
    }

    void setInfo(T info) {
        this.info = info;
    }

    void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    void setRight(TreeNode<T> right) {
        this.right = right;
    }

    T getInfo() {
        return this.info;
    }

    TreeNode<T> getLeft() {
        return this.left;
    }

    TreeNode<T> getRight() {
        return this.right;
    }

    void insertNode(T value) {
        if (value.compareTo(this.getInfo()) == 0) {
            System.out.println("Valor repetido.");
        } else if (value.compareTo(this.getInfo()) < 0) {
            if (this.left == null) {
                this.left = new TreeNode<T>(value);
            } else {
                this.left.insertNode(value);
            }
        } else {
            if (this.right == null) {
                this.right = new TreeNode<T>(value);
            } else {
                this.right.insertNode(value);
            }
        }
    }
    
    T findNode (T value) {
        if (this.getInfo().compareTo(value) == 0) {
            return this.getInfo();
        }
        else if (value.compareTo(this.getInfo()) < 0) {
            if (this.getLeft() == null){
                return null;
            }
            else {
                return this.getLeft().findNode (value);
            }
        }
        else {
            if (this.getRight() == null){
                return null;
            }
            else {
                return this.getRight().findNode (value);
            }
        }
    }
}
