package LinkedListPrograms;

/**
 * Created by Goutam on 9/5/2017.
 */
public class DeleteNodeLL {
    public static Node head;

    public static class Node {
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public static void deleteKthNode(Node node){
        Node nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
        //System.gc();
        nextNode = null;
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
        System.out.println("The list initially was: ");
        printLL(head);
        deleteKthNode(head.next );
        System.out.println("\nThe list after delete operation is: ");
        printLL(head);
    }
}
