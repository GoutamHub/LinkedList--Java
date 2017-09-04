package LinkedListPrograms;

/**
 * Created by Goutam on 9/3/2017.
 */
public class RotateLL {
    public static Node head;
    
    public static class Node{
        int data;
        Node next;
        
        Node(int d){
            data = d;
            next =  null;
        }
    }
    
    public static void printLL(Node node){
        
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static Node rotateLL(Node head, int k){
        
        if(k==0)
            return head;
        
        Node currentNode = head;
        int count = 1;
        
        while(count<k && currentNode!=null){
            currentNode = currentNode.next;
            count++;
        }
        
        if(currentNode == null)
            return head;

        Node kthNode = currentNode;
        
        while(currentNode.next != null)
            currentNode = currentNode.next;
        
        currentNode.next = head;
        
        head = kthNode.next;
        
        kthNode.next = null;
        
        return head;
        
    }
    
    
    public static void main(String args[]){
        RotateLL list = new RotateLL();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        
        System.out.println("List before rotation: ");
        printLL(head);
        System.out.println("\nList after rotation: ");
        head = rotateLL(head, 4);
        printLL(head);
    }
}
