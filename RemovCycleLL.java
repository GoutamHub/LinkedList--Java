package LinkedListPrograms;

import java.util.HashMap;

/**
 * Created by Goutam on 9/5/2017.
 */
public class RemovCycleLL {
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
    

    public static void detectAndRemoveCycleUsingFloydAlgo(Node head){
        if(head == null || head.next == null)
            return;
        
        Node fastMover = head;
        Node slowMover = head;

        while(fastMover!=null && fastMover.next!=null){
            fastMover = fastMover.next.next;
            slowMover = slowMover.next;

            if(fastMover == slowMover)
                break;
        }
        
        if(fastMover == slowMover){
            slowMover = head;
            
            while(slowMover.next!=fastMover.next){
                slowMover = slowMover.next;
                fastMover = fastMover.next;
            }
            
            fastMover.next = null;
        }
        
    }

    public static void main(String args[]){
        RemovCycleLL list = new RemovCycleLL();

        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = head.next.next;

        detectAndRemoveCycleUsingFloydAlgo(head);
        System.out.println("The list after remove the loop from it: ");
        printLL(head);
        
        
    }
}
