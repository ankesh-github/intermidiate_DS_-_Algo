package tree_datastructure;

import com.sun.source.tree.BinaryTree;

import java.util.Arrays;

public class TreeStructureDemo {
    public static void main(String[] args) {
        int [] arr = {23,67,54,34,76,80};
        System.out.println();
        Arrays.stream(arr).forEach(e -> System.out.print(e+ "  "));
        BinaryTreeByLinkedList tree = new BinaryTreeByLinkedList();
        createTreeStructure(tree, arr);
    }

    public static void createTreeStructure(BinaryTreeByLinkedList tree,  int [] arr){
        for(int num : arr){
            tree.insert(num);
        }
    }
}
