package LinkedListPrograms;

/**
 * Created by Goutam on 9/7/2017.
 */
public class AddLLMsb {
    public static Node head1, head2, resultHead;
    public static int carry = 0;
    public static Node currentNode = null;
    
    public static class Node{
        int data;
        Node next;
        Node(int d){
          data = d;
          next = null;
        }
    }
    
    public static void printLL(Node node){
        Node currentNode = node;
        while(currentNode!=null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }
    
    
    public static int getSize(Node head){
        Node currentNode = head;
        int count = 0;
        while(currentNode!=null){
            currentNode = currentNode.next;
            count++;
        }
        
        return count;
    }
    
    public static void sumSameSizeLL(Node m, Node n){
        if(m == null)
            return;
        
        sumSameSizeLL(m.next, n.next);
        
        int sum = m.data + n.data + carry;
        carry = sum/10;
        sum = sum%10;
        
        pushIntoResultLL(sum);
        
    }
    
    public static void pushIntoResultLL(int value){
        Node newNode = new Node(value);
        
        newNode.next = resultHead;
        resultHead = newNode;
    }
    
    public static void propagateCarry(Node head){
        if(head!=currentNode){
            propagateCarry(head.next);
            int sum = head.data + carry;
            carry = sum/10;
            sum = sum%10;
            
            pushIntoResultLL(sum);
        }
    }
    
    
    public static Node addLists(Node head1, Node head2){
        if(head1 == null)
            return head2;
        
        if(head2 == null)
            return head1;
        
        int size1 = getSize(head1);
        int size2 = getSize(head2);
        
        if(size1 == size2){
            sumSameSizeLL(head1, head2);
            if(carry>0)
                pushIntoResultLL(carry);
        }else{
            int diff = 0;
            if(size1 > size2) {
                diff = Math.abs(size1 - size2);
                while (diff-- >=0 ){
                    currentNode = head1;
                    head1 = head1.next;
                }
                sumSameSizeLL(currentNode, head2);
                propagateCarry(head1);
            }
            else{
                diff = Math.abs(size2-size1);
                while (diff-- >=0 ){
                    currentNode = head2;
                    head2 = head2.next;
                }
                sumSameSizeLL(head1, currentNode);
                propagateCarry(head2);
            }
            
            if(carry>0)
                pushIntoResultLL(carry);
        }
        return resultHead;
    }
    
    public static void main(String args[]){
        AddLLMsb list = new AddLLMsb();
        head1 = new Node(5);
        head1.next = new Node(7);
        System.out.println("The 1st list is given as: ");
        printLL(head1);

        head2 = new Node(8);
        head2.next = new Node(9);
        System.out.println("\nThe 2nd list is given as: ");
        printLL(head2);
        
        Node resultHead = addLists(head1, head2);
        System.out.println("\nThe resultList will be: ");
        printLL(resultHead);
        
    }
}
