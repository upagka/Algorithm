package lesson6;

import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

        TreeImpl<Integer> tree = new TreeImpl<>(4);

        ArrayList<TreeImpl> trees = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            trees.add(generateTree(4, 20));
            trees.get(i).display();
            System.out.println(trees.get(i).isTreeBalanced());
        }




//        trees.get(1).display();
//
//        trees.get(1).traverse(Tree.TraversMode.IN_ORDER);
//        trees.get(1).traverse(Tree.TraversMode.PRE_ORDER);
//        trees.get(1).traverse(Tree.TraversMode.POST_ORDER);

    }

    private static TreeImpl generateTree(int maxLevel, int tries) {
        TreeImpl newTree = new TreeImpl(4);
        for (int i = 0; i < tries; i++) {
            Random rand = new Random();
            int int_random = rand.nextInt(51) - 25;
            newTree.add(int_random);
        }
        return newTree;
    }


}
