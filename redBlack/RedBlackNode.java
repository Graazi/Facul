package redBlack;

	public class RedBlackNode <T extends Comparable<T>>{
		private int data;
		private RedBlackNode <T> left;
        private RedBlackNode <T> right;
		private char colour;
		private RedBlackNode <T> parent;
        private RedBlackNode <T> root;

		public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public RedBlackNode<T> getLeft() {
            return left;
        }
        public void setLeft(RedBlackNode<T> left) {
            this.left = left;
        }
        public RedBlackNode<T> getRight() {
            return right;
        }
        public void setRight(RedBlackNode<T> right) {
            this.right = right;
        }
        public char getColour() {
            return colour;
        }
        public void setColour(char colour) {
            this.colour = colour;
        }
        public RedBlackNode<T> getParent() {
            return parent;
        }
        public void setParent(RedBlackNode<T> parent) {
            this.parent = parent;
        }
        public RedBlackNode<T> getRoot() {
            return root;
        }
        public void setRoot(RedBlackNode<T> root) {
            this.root = root;
        }

}

