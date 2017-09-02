package LinkedListPrograms;

/**
 * Created by Goutam on 9/2/2017.
 */

public class ReverseLLinK {
    public static Node head;
    
    public static class Node{
        int data;
        Node next;
        
        Node(int d){
            data = d;
            next = null;
        }
        
    }
    
    public static Node reverseInGroup(Node head, int k){
        Node previousNode = null;
        Node currentNode = head;
        Node nextNode = null;
        
        int count = 0;
        
        while(currentNode!=null && count<k){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            count++;
        }
        
        if(nextNode!=null)
            head.next = reverseInGroup(nextNode, 3);

        head = previousNode;
        return head;
    }
    
    public static void traverseList(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main(String args[]){
        ReverseLLinK reLL = new ReverseLLinK();
        reLL.head = new Node(1);
        reLL.head.next = new Node(2);
        reLL.head.next.next = new Node(3);
        reLL.head.next.next.next = new Node(4);
        reLL.head.next.next.next.next = new Node(5);
        reLL.head.next.next.next.next.next = new Node(6);
        System.out.println("The list before Reverse Operation: ");
        traverseList(head);
        System.out.println("\nThe list after Reverse Operation: ");
        head = reverseInGroup(head, 3);
        traverseList(head);
    }
}
