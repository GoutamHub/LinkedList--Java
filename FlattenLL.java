package LinkedListPrograms;

/**
 * Created by Goutam on 9/4/2017.
 */
public class FlattenLL {
    public static Node head;

    public static class Node{
        int data;
        Node nextRight;
        Node nextDown;

        Node(int d){
            data = d;
            nextRight = null;
            nextDown = null;
        }
    }

    public static void printLL(Node node){
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.nextDown;
        }
        System.out.println();
    }
    
    public static Node pushNode(Node headReference, int data){
        Node newNode = new Node(data);
        newNode.nextDown = headReference;
        
        headReference = newNode;
        return headReference;
    }

    public static Node mergeSortedLLInPlace(Node head1, Node head2){

        if(head1 == null)
            return head2;
        if(head2 == null)
            return  head1;

        if(head1.data <= head2.data){
            head1.nextDown = mergeSortedLLInPlace(head1.nextDown, head2);
            return head1;
        } else {
            head2.nextDown = mergeSortedLLInPlace(head1, head2.nextDown);
            return head2;
        }
    }
    
    
    public static Node flattern(Node head){
        
        if(head == null || head.nextRight == null)
            return head;
        
        head.nextRight = flattern(head.nextRight);
        
        head = mergeSortedLLInPlace(head, head.nextRight);
        
        return head;
    }

    public static void main(String args[]){
        FlattenLL list = new FlattenLL();
        
        list.head = list.pushNode(list.head, 30);
        list.head = list.pushNode(list.head, 8);
        list.head = list.pushNode(list.head, 7);
        list.head = list.pushNode(list.head, 5);
        
        list.head.nextRight = list.pushNode(list.head.nextRight, 20);
        list.head.nextRight = list.pushNode(list.head.nextRight, 10);

        list.head.nextRight.nextRight = list.pushNode(list.head.nextRight.nextRight, 50);
        list.head.nextRight.nextRight = list.pushNode(list.head.nextRight.nextRight, 22);
        list.head.nextRight.nextRight = list.pushNode(list.head.nextRight.nextRight, 19);

        list.head.nextRight.nextRight.nextRight = list.pushNode(list.head.nextRight.nextRight.nextRight, 45);
        list.head.nextRight.nextRight.nextRight = list.pushNode(list.head.nextRight.nextRight.nextRight, 40);
        list.head.nextRight.nextRight.nextRight = list.pushNode(list.head.nextRight.nextRight.nextRight, 35);
        list.head.nextRight.nextRight.nextRight = list.pushNode(list.head.nextRight.nextRight.nextRight, 28);
        
        head = list.flattern(list.head);

        System.out.println("\nThe List after flatOperation: ");
        printLL(head);
    }
}
