package LinkedListPrograms;

import java.util.HashMap;

/**
 * Created by Goutam on 9/5/2017.
 */
public class CycleDetectionLL {
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
            System.out.print(node.data+ " ");
            node = node.next;
        }
    }
    
    
    public static boolean detectCycleUsingHash(Node head){
        HashMap<Node, Boolean> hm = new HashMap<>();
        Node currentNode = head;
        
        while(currentNode!=null){
            if(hm.containsKey(currentNode))
                return true;
            hm.put(currentNode, true);
            currentNode = currentNode.next;
        }
        return false;
    }
    
    public static boolean detectCycleUsingFloydAlgo(Node head){
        Node fastMover = head;
        Node slowMover = head;
        
        while(fastMover!=null && slowMover!=null && fastMover.next!=null){
            fastMover = fastMover.next.next;
            slowMover = slowMover.next;
            
            if(fastMover == slowMover)
                return true;
        }
        return false;
    }
    
    public static void main(String args[]){
        CycleDetectionLL list = new CycleDetectionLL();
        
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = head.next;
        
        System.out.println("Is loop exists in given List: " + detectCycleUsingHash(head));

        System.out.println("Is loop exists in given List: " + detectCycleUsingFloydAlgo(head));
    }
}
