class TreeNode<T extends Comparable<T>> {
    private T data;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(T data) {
        this.data = data;
    }

    public void insert(T data) {
        if (data.compareTo(this.data) < 0) {
            if (leftChild == null) {
                leftChild = new TreeNode<>(data);
            } else {
                leftChild.insert(data);
            }
        } else if (data.compareTo(this.data) > 0) {
            if (rightChild == null) {
                rightChild = new TreeNode<>(data);
            } else {
                rightChild.insert(data);
            }
        }
    }

    public T search(T data) {
        if (data.equals(this.data)) {
            return this.data;
        } else if (data.compareTo(this.data) < 0) {
            if (leftChild != null) {
                return leftChild.search(data);
            }
        } else if (data.compareTo(this.data) > 0) {
            if (rightChild != null) {
                return rightChild.search(data);
            }
        }
        return null;
    }

    public void inOrderTraversal() {
        if (leftChild != null) {
            leftChild.inOrderTraversal();
        }
        System.out.println(data.toString());
        if (rightChild != null) {
            rightChild.inOrderTraversal();
        }
    }
}

