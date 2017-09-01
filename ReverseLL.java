package LinkedListPrograms;

/**
 * Created by Goutam on 8/28/2017.
 */
public class ReverseLL {
    /*head object: holds the starting address for List at any point of time*/
    static Node head;
    
    private static class Node{
        int data;
        Node next;
        /*Parameterized Constructor for Class Node.
         * Constructor won't return anything, this will initialize the values
          * for Node variables */
        Node(int d){
            data = d;
            next = null;
        }
    }
    
    
    
    public Node reverseIterative(Node head){
        Node previousNode = null;
        Node currentNode = head;
        Node nextNode = null;
        while(currentNode!= null){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
        return head;
    }
    
    public Node reverseRecursive(Node currentNode, Node previousNode){
        
        if(currentNode.next == null){
            head = currentNode;
            
            currentNode.next = previousNode;
            return null;
        }
        
        Node nextNode = currentNode.next;
        currentNode.next = previousNode;
        
        reverseRecursive(nextNode, currentNode);
        return head;
    }
    
    public void traverseLL(Node node) {
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main(String args[]){
       ReverseLL list = new ReverseLL();
       /* HEAD ---> 1 ---> 2 ---> 3 ---> 4 ---> NULL */
       list.head = new Node(1);
       list.head.next = new Node(2);
       list.head.next.next = new Node(3);
       list.head.next.next.next = new Node(4);
       /*System.out.println("List Before Reverse Operation:");
       list.traverseLL(head);
       head = list.reverseIterative(head);
       System.out.println("\n" + "List After Reverse Operation:");
       list.traverseLL(head);*/
       /*Recursive-method Call*/
        System.out.println("List Before Reverse Operation:");
        list.traverseLL(head);
        head = list.reverseRecursive(head, null);
        System.out.println("\n" + "List After Reverse Operation:");
        list.traverseLL(head);
       
    }
}
