package tree_datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeByLinkedList {
    BinaryNode root;

    public BinaryTreeByLinkedList(){
        this.root = null;
    }

    public void insert(int value){
        BinaryNode node = new BinaryNode();
        node.setValue(value);
        if(root == null){
            root = node;
            System.out.println("Successfully inserted new node at root !");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(presentNode.getLeft() == null){
                presentNode.setLeft(node);
                System.out.println("Successfully inserted new node at left of "+presentNode.getValue() );
                break;
            }
            else if(presentNode.getRight() == null){
                presentNode.setRight(node);
                System.out.println("Successfully inserted new node at right of "+presentNode.getValue() );
                break;
            }
            else{
                queue.add(presentNode.getLeft());
                queue.add(presentNode.getRight());
            }
        }

    }
}
