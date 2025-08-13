package linkedList;

public class DeletionOfLinkedList {
    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 8, 9, 6, 7, 2, 1, 5};
        Node head = new Node(arr[0]);
        head = convertArrayToLinkedList(head, arr);
        printLinkedList(head);
        head = deleteHeadNode(head);
        printLinkedList(head);
        head = deleteTailNode(head);
        printLinkedList(head);
        head = deleteNodeAtKthPosition(head, 7);
        printLinkedList(head);

    }

    private static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node convertArrayToLinkedList(Node head, int[] arr) {
        if (arr == null || arr.length <= 1) {
            return head;
        }
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = temp.next;
        }
        return head;

    }

    private static Node deleteHeadNode(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head.next;
        head.next = null;
        return temp;
    }

    private static Node deleteTailNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;

        }
        temp.next = null;
        return head;
    }

    private static Node deleteNodeAtKthPosition(Node head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        if (k == 1) {
            return deleteHeadNode(head);
        }
        Node temp = head;
        Node prev = null;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k) {
                prev.next = temp.next;
                temp.next = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
