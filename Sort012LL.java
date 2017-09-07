package LinkedListPrograms;

/**
 * Created by Goutam on 9/7/2017.
 */
public class Sort012LL {
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
    
    public static void sort(Node head){
        int count[] = new int[]{0,0,0};
        Node currentNode = head;
        while(currentNode!=null){
            count[currentNode.data]++;
            currentNode = currentNode.next;
        }
        
        currentNode = head;
        int i=0;
        while(currentNode!=null){
            if(count[i] == 0){
                i++;
            }else{
                currentNode.data = i;
                currentNode = currentNode.next;
                count[i]--;
            }
        }
    }

    public static void main(String args[]){
        Sort012LL list = new Sort012LL();
        head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(0);
        System.out.println("The list given is: ");
        printLL(head);
        sort(head);
        System.out.println("\nList after the Sort operation: ");
        printLL(head);
    }
    
}
