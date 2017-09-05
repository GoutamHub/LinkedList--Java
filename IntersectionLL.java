package LinkedListPrograms;

/**
 * Created by Goutam on 9/5/2017.
 */
public class IntersectionLL {
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

    public static int intersectionLL(Node head1, Node head2){
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        if(c1==0 || c2 == 0){
            System.out.println("No Intersection Node exists..");
            return -1;
        }
        int result = 0;
        
        if(c1 > c2){
            int d = c1-c2;
            result = getTheNode(d, head1, head2);
        } else{
            int d = c2-c1;
            result = getTheNode(d, head2, head1);
        }
       
        return result;
    }
    
    public static int getCount(Node head){
        if(head == null)
            return 0;
        Node currentNode = head;
        int count = 0;
        while(currentNode!=null){
            currentNode = currentNode.next;
            count++;
        }
        return count;
    }
    
    public static int getTheNode(int d, Node newhead1, Node newhead2){
        Node currentNode1 = newhead1;
        Node currentNode2 = newhead2;
        
        for(int i=0; i<d; i++)
            currentNode1 = currentNode1.next;
        
        while(currentNode1!= null && currentNode2!=null){
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
            if(currentNode1.data == currentNode2.data)
                return currentNode1.data;
        }
        return 0;
    }


    public static void main(String args[]){
        head1 = new Node(10);
        head1.next = new Node (15);
        head1.next.next = new Node(30);
        System.out.println("The List1 is: ");
        printLL(head1);

        head2 = new Node(13);
        head2.next = new Node (15);
        head2.next.next = new Node(27);
        head2.next.next.next = new Node(33);
        System.out.println("\nThe List2 is: ");
        printLL(head2);

        int intersectNode = intersectionLL(head1, head2);
        System.out.println("\nThe Result is: " + intersectNode);
    }
    
}
