package LinkedListPrograms;

import java.util.Stack;

/**
 * Created by Goutam on 9/6/2017.
 */
public class PalindromeLL {
    public static Node head;

    public static class Node{
        String data;
        Node next;

        Node(String d){
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
    
    public static boolean isPalindromeUsingStack(Node head){
        Stack<String> tempStack = new Stack<>();
        if(head == null){
            System.out.println("No Node exists in the List!!!");
            return false;
        }
        
        Node currentNode = head;
        
        while(currentNode!=null){
            tempStack.push(currentNode.data);
            currentNode = currentNode.next;
        }
        
        currentNode = head;
        
        while(currentNode!=null || tempStack.size() > 0){
            if(currentNode.data != tempStack.pop())
                return false;
            currentNode = currentNode.next;
        }
        
        return true;
    }
    
    public static boolean isPalindromeRecursive(Node head){
        boolean result = isPalindromeRecursiveUtils(head);
        return result;
    }
    
    public static boolean isPalindromeRecursiveUtils(Node head){
        
        Node right = head;
        Node left = head;
        
        if(right == null){
            return true;
        }
        
        boolean tempResult = isPalindromeRecursiveUtils(right.next);
        
        if(tempResult == false)
            return false;
        
        boolean finalResult = (left.data == right.data)? true : false;
        left = left.next;
        
        return finalResult;
    }

    public static void main(String args[]) {
        PalindromeLL list = new PalindromeLL();
        head = new Node("A");
        head.next = new Node("B");
        head.next.next = new Node("C");
        head.next.next.next = new Node("B");
        head.next.next.next.next = new Node("A");
        System.out.println("The list given is: ");
        printLL(head);
        boolean result = isPalindromeUsingStack(head);
        System.out.println("\nThe result after Palindrome check operation: "  + result);
        result = isPalindromeRecursive(head);
        System.out.println("\nThe result after Palindrome check operation: "  + result);
    }
}
