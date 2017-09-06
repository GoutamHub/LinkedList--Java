package LinkedListPrograms;

/**
 * Created by Goutam on 9/5/2017.
 */
public class SwapNodesinPairsLL {
    public static Node head;
    
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
    
    public static Node pairSwap(Node head){
        /*Key idea is to think the problem in minimize way 
        * How we can achieve : Case-1: 1->2->3 to 2->1->3 And
        * How we can achieve : Case-2: 1->2->3->4 to 2->1->4->3*/
        
        /*if LinkedList is empty or consists with Only 1 node*/
        if(head == null || head.next == null)
            return null;
        
        /*Initialize all necessary variables which we need for swapping the pair nodes*/
        Node previousNode = head;
        Node currentNode = head.next;
        Node nextNode = null;
        
        /*Create and initialize the newHead node i.e. start of the result LL*/
        Node newHead = currentNode;
        
        
        while(true){
           /*think about only swapping 1->2 to 2->1 and assign values to nextNode, previousNode and currentNode accordingly*/
           nextNode = currentNode.next;
           currentNode.next = previousNode;
           
           /*Think about the scenario 1->2->3 to 2->1->3*/
           if(nextNode == null || nextNode.next == null){
               previousNode.next = nextNode;
               break;
           }
           
           /*Think about the scenario 1->2->3->4 to 2->1->4->3*/
            previousNode.next = nextNode.next;
            
            /*update again for previous and current node*/
            previousNode = nextNode;
            currentNode = previousNode.next;
            
        }
        
        return newHead;
    }
    
    public static Node pairSwapRecursive(Node head){
        
        /*if LinkedList is empty or consists with Only 1 node*/
        if(head == null || head.next == null)
            return null;
        
        /*Create and initialize the newHead node i.e. start of the result LL*/
        Node newHead = head.next;
        
        /*Head node creation for remaining part and assign as 3->4->5->6*/
        Node remainingNodeHead = head.next.next;
        
        /*consider the case 1->2 and how to change it to 2->1*/
        head.next.next = head;
        
        /*recursive call for remaining list*/
        head.next = pairSwapRecursive(remainingNodeHead);
        
        return newHead;
    }
    
    public static void main(String args[]){
        SwapNodesinPairsLL list = new SwapNodesinPairsLL();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        System.out.println("The list given is: ");
        printLL(head);
        /*Node newhead = pairSwap(head);
        System.out.println("\nThe list after swap operation: ");
        printLL(newhead);*/
        Node newhead1 = pairSwapRecursive(head);
        System.out.println("\nThe list after swap operation recursively: ");
        printLL(newhead1);
    }
    
}
