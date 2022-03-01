package domain;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	public boolean lookup(E data) {
		if (data.compareTo(this.data) == 0) return true;
		else {
			if (data.compareTo(this.data) < 0) {
				if (leftTree == null) return false;
				else return leftTree.lookup(data);
			} else {
				if (rightTree == null) return false;
				else return rightTree.lookup(data);
			}
		}
	}

	public boolean addNode(E data) {
		if (data.compareTo(this.data) < 0) {
			if (leftTree == null) {
				leftTree = new BinarySearchTree<E>(data);
				return true;
			}
			else return leftTree.addNode(data);
		} else if (rightTree == null) {
			rightTree = new BinarySearchTree<E>(data);
			return true;
		}
		else return rightTree.addNode(data);
	}

	public boolean removeNode(E data){
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public E searchSmallest(){
		if (leftTree == null) return this.data;
		else return leftTree.searchSmallest();
	}

	public E searchGreatest(){
		if (rightTree == null) return this.data;
		else return rightTree.searchGreatest();
	}

	public ArrayList<E> getPath(E data) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

}


