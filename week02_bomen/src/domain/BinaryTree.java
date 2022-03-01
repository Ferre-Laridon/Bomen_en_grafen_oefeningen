package domain;

public class BinaryTree<E> {
    private E data;
    private BinaryTree<E> leftTree, rightTree;

    public BinaryTree(E data) {
        this(data, null, null);
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        if (data == null) {
            throw new IllegalArgumentException();
        }

        this.data = data;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public void printPreorder() {
        System.out.print(this.data + " ");
        if (this.leftTree != null) this.leftTree.printPreorder();
        if (this.rightTree != null) this.rightTree.printPreorder();
    }

    public void printInorder() {
        if (this.leftTree != null) this.leftTree.printInorder();
        System.out.print(this.data + " ");
        if (this.rightTree != null) this.rightTree.printInorder();
    }

    public void printPostorder() {
        if (this.leftTree != null) this.leftTree.printPostorder();
        if (this.rightTree != null) this.rightTree.printPostorder();
        System.out.print(this.data + " ");
    }

    public int countNodes() {
        if (this.leftTree == null && this.rightTree == null) return 1;
        else if (this.leftTree != null && this.rightTree == null) return 1 + this.leftTree.countNodes();
        else if (this.leftTree == null) return 1 + this.rightTree.countNodes();
        else return 1 + this.leftTree.countNodes() + this.rightTree.countNodes();
    }

    public int getDepth() {
        if (this.leftTree == null && this.rightTree == null) return 1;
        else if (this.leftTree != null && this.rightTree == null) return 1 + this.leftTree.getDepth();
        else if (this.leftTree == null) return 1 + this.rightTree.getDepth();
        else return 1 + Math.max(this.leftTree.getDepth(), this.rightTree.getDepth());
    }

    public boolean isLeaf() {
        return (this.leftTree == null && this.rightTree == null);
    }

    public int countLeaves() {
        if (this.leftTree == null && this.rightTree == null) return 1;
        else if (this.leftTree == null) return this.rightTree.countLeaves();
        else if (this.rightTree == null) return this.leftTree.countLeaves();
        else if (this.leftTree.isLeaf()) return 1 + this.rightTree.countLeaves();
        else if (this.rightTree.isLeaf()) return 1 + this.leftTree.countLeaves();
        else return this.leftTree.countLeaves() + this.rightTree.countLeaves();
    }

    public void getDataLeaves() {
        if (this.leftTree == null && this.rightTree == null) System.out.print(this.data + " ");
        else if (this.leftTree == null) this.rightTree.getDataLeaves();
        else if (this.rightTree == null) this.leftTree.getDataLeaves();
        else if (this.leftTree.isLeaf()) {
            System.out.print(this.leftTree.data + " ");
            this.rightTree.getDataLeaves();
        } else if (this.rightTree.isLeaf()){
            System.out.print(this.rightTree.data + " ");
            this.leftTree.getDataLeaves();
        }
        else {
            this.leftTree.getDataLeaves();
            this.rightTree.getDataLeaves();
        }
    }

    public boolean contains(E data) {
        if (this.data == data) return true;
        else if (this.rightTree != null && this.leftTree != null)
            return (this.leftTree.contains(data) || this.rightTree.contains(data));
        else if (this.leftTree == null && this.rightTree != null) return this.rightTree.contains(data);
        else if (this.leftTree != null) return this.leftTree.contains(data);
        else return false;
    }

}
