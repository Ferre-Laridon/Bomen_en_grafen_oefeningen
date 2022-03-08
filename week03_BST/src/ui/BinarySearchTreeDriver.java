package ui;

import domain.BinarySearchTree;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		//BinarySearchTree<Integer> boom = new BinarySearchTree<Integer>(6);
		//boom.addNode(4);
		//boom.addNode(8);
		//boom.addNode(3);
		//boom.addNode(5);
		//boom.addNode(7);
		//boom.addNode(9);

		BinarySearchTree<Integer> boom = new BinarySearchTree<Integer>(5);
		boom.addNode(4);
		boom.addNode(8);
		boom.addNode(3);
		boom.addNode(7);
		boom.addNode(9);

		printBoomInfo(boom);

	}

	private static void printBoomInfo(BinarySearchTree<Integer> boom) {
		if (boom == null) System.out.println("Lege boom");
		else {
			boom.printInorder();
			System.out.println();
			System.out.println(boom.lookup(5));
			System.out.println(boom.lookup(7));
			System.out.println(boom.lookup(15));
			System.out.println("De grootste waarde uit deze boom = " + boom.searchGreatest());
			System.out.println("De kleinste waarde uit deze boom = " + boom.searchSmallest());
			System.out.println("Pad tot aan 7 = " + boom.getPath(7));
			System.out.println("Pad tot aan 4 = " + boom.getPath(4));
			System.out.println("Pad tot aan 8 = " + boom.getPath(8));
			System.out.println("Pad tot aan 22 = " + boom.getPath(22));
			System.out.println("Pad tot aan 2 = " + boom.getPath(2));
		}
	}

	//private static void printBoom2Info(BinarySearchTree<Integer> boom2) {
	//	if (boom2 == null) System.out.println("Lege boom");
	//	else {
	//		boom2.printInorder();
	//		System.out.println();
	//		System.out.println("Pad tot aan 7 = " + boom2.getPath(7));
	//		System.out.println("Pad tot aan 4 = " + boom2.getPath(4));
	//		System.out.println("Pad tot aan 8 = " + boom2.getPath(8));
	//		System.out.println("Pad tot aan 22 = " + boom2.getPath(22));
	//	}
	//}
}
