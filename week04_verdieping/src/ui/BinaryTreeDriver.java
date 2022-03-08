package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

    public static void main(String[] args) {
        BinaryTree<String> nodeE3 = new BinaryTree<>("E");
        BinaryTree<String> nodeE4 = new BinaryTree<>("E");
        BinaryTree<String> nodeE1 = new BinaryTree<>("E");
        BinaryTree<String> nodeE2 = new BinaryTree<>("E");
        BinaryTree<String> nodeA2 = new BinaryTree<>("A");

        BinaryTree<String> nodeC = new BinaryTree<>("C", null, nodeE3);
        BinaryTree<String> nodeH3 = new BinaryTree<>("H", null, nodeE4);
        BinaryTree<String> nodeH2 = new BinaryTree<>("H", nodeC, nodeE1);
        BinaryTree<String> nodeI = new BinaryTree<>("I", nodeH2, nodeE2);
        BinaryTree<String> nodeH1 = new BinaryTree<>("H", nodeA2, nodeH2);
        BinaryTree<String> nodeG = new BinaryTree<>("G", null, nodeI);
        BinaryTree<String> nodeA1 = new BinaryTree<>("A", nodeH1, nodeG);

    }

}
