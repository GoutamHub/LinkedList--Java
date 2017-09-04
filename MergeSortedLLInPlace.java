package LinkedListPrograms;

/**
 * Created by Goutam on 9/4/2017.
 */
public class MergeSortedLLInPlace {
    public static Node head1;
    public static Node head2;
    
    public static class Node{
        int data;
        Node next;
        
        Node(int d){
            data = d;
            next = null;
        }
    }
    
    public static void printLL(Node node){
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static Node mergeSortedLLInPlace(Node head1, Node head2){
        
        if(head1 == null)
            return head2;
        if(head2 == null)
            return  head1;
        
        if(head1.data <= head2.data){
            head1.next = mergeSortedLLInPlace(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeSortedLLInPlace(head1, head2.next);
            return head2;
        }
    }
    
    public static void main(String args[]){
        head1 = new Node(10);
        head1.next = new Node (20);
        head1.next.next = new Node(40);
        System.out.println("The List1 is: ");
        printLL(head1);

        head2 = new Node(13);
        head2.next = new Node (17);
        System.out.println("\nThe List2 is: ");
        printLL(head2);

        Node newHead = mergeSortedLLInPlace(head1, head2);
        System.out.println("\nThe Result List is: ");
        printLL(newHead);
    }
}
