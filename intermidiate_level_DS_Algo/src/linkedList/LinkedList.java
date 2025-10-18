package linkedList;

public class LinkedList {
    public static void main(String [] args){
        int [] arr = {2, 5, 1, 4, 8, 0, 8, 1, 3, 8};
        Node head = new Node(arr[0]);
        System.out.println(head.data);

        head = convertArrayToLinkedList(head, arr);
        printLinkedList(head);
        System.out.println("Length of Linked List : " + lengthOfLinkedList(head));
        System.out.println("Search Element 8 : " + searchElement(head, 8));
    }

    private static void printLinkedList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node convertArrayToLinkedList(Node head, int [] arr){
        if(arr == null || arr.length <= 1){
            return head;
        }
        Node temp = head;
        for(int i =1; i< arr.length; i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = temp.next;

        }
        return head;
    }

    private static int lengthOfLinkedList(Node head){
        if(head == null){
            return 0;
        }
        int count =0;
        Node temp = head;
        while(temp != null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    private static boolean searchElement (Node head, int value){
        if(head == null){
            return false;
        }
        Node temp = head;
        while(temp != null){
            if(temp.data == value){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }



}
