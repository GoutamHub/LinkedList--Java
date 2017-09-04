package LinkedListPrograms;

/**
 * Created by Goutam on 9/4/2017.
 */
public class NthFromLastLL {
    public static Node head;

    public static class Node {
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public static void findKthFromLast(Node head, int k){
        Node earlyMover = head;
        Node delayMover = head;
        int count =0;

        if(head!=null) {
            while (earlyMover!=null && count<k) {
                earlyMover = earlyMover.next;
                count++;
            }

            if(earlyMover == null){
                System.out.println("Given value of n is greater than the List length");
                return;
            }
            
            while(earlyMover!=null){
                earlyMover = earlyMover.next;
                delayMover = delayMover.next;
            }
            System.out.println("\nThe n'th element from last is : " + delayMover.data);
        }
    }

    public static void printLL(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String args[]){
        NthFromLastLL list = new NthFromLastLL();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println("The list: ");
        printLL(head);
        findKthFromLast(head, 2);
    }
}
