package LinkedListPrograms;

/**
 * Created by Goutam on 9/3/2017.
 */
public class FindMiddle {
    public static Node head;
    
    public static class Node {
        int data;
        Node next;
        
        Node(int d){
            data = d;
            next = null;
        }
    }
    
    public static void findMiddle(Node head){
        Node fastMover = head;
        Node slowMover = head;
        
        if(head!=null) {
            while (fastMover!=null && fastMover.next!=null) {
                fastMover = fastMover.next.next;
                slowMover = slowMover.next;
            }
            System.out.println("\nThe middle element is : " + slowMover.data);
        }
    }
    
    public static void printLL(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main(String args[]){
        FindMiddle list = new FindMiddle();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println("The list: ");
        printLL(head);
        findMiddle(head);
    }
}
