package dailyPractice;

public class LinkedList {
    static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data=data;
            this.next = null;
        }
    }

    private static ListNode createLinkedList(int [] arr, ListNode head ){
        if(arr == null){
            return head;
        }
        int i=0;
        if(head == null){
            head = new ListNode(arr[0]);
            i++;
        }
        ListNode temp = head;
        while(i<arr.length){
            ListNode newNode = new ListNode(arr[i]);
            temp.next = newNode;
            temp = newNode;
            i++;
        }
        return head;
    }

    private static void print(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();

    }

    private static ListNode addTwoNumbers(ListNode head1, ListNode head2){
        if(head1!=null && head2!=null){
            ListNode dummyNode = new ListNode(-1);
            ListNode resNode = dummyNode;
            int carry=0;
            ListNode temp1 = head1;
            ListNode temp2 = head2;
            while(temp1 != null && temp2 != null){
                int sum = temp1.data + temp2.data + carry;
                ListNode newNode = new ListNode(sum%10);
                resNode.next=newNode;
                resNode = newNode;
                carry = sum/10;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            while(temp1!=null){
                int sum = temp1.data + carry;
                ListNode newNode = new ListNode(sum%10);
                resNode.next=newNode;
                resNode = newNode;
                carry = sum/10;
                temp1 = temp1.next;

            }
            while(temp2!=null){
                int sum = temp2.data + carry;
                ListNode newNode = new ListNode(sum%10);
                resNode.next=newNode;
                resNode = newNode;
                carry = sum/10;
                temp2 = temp2.next;

            }
            if(carry > 0){
                ListNode newNode = new ListNode(carry);
                resNode.next=newNode;
            }
            return dummyNode.next;
        }
        return head1 == null ? head2 : head1;
    }

    public static void main (String [] args){
        int [] arr1 = {1,2,3,4,5,6};
        int [] arr2 = {5,6,9,8,6};
        ListNode head1 = createLinkedList(arr1, null);
        ListNode head2 = createLinkedList(arr2, null);
        print(head1);
        print(head2);
        ListNode head3 = addTwoNumbers(head1, head2);
        print(head3);

    }

}
