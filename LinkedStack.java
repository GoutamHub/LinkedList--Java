package LinkedListPrograms;

import java.util.Iterator;

/**
 * Created by Goutam on 9/7/2017.
 */

/*http://cs-fundamentals.com/data-structures/stack-implementation-using-linked-list-in-java.php*/

interface Stack <Item> extends Iterable <Item> {
    Item pop(); // return the top item and removes it from stack
    void push(Item item); // adds an item to the stack
    boolean isEmpty(); // returns true if stack is empty, false otherwise
    int size();  // returns the number of items in stack right now
}

class LinkedStack <Item> implements Stack <Item>{
    private Node head; //the first node
    private int size; // number of items

    //nested class to define node
    private class Node
    {
        Item item;
        Node next;
    }

    //Zero argument constructor
    public LinkedStack()
    {
        head = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    //Remove item from the beginning of the list.
    public Item pop()
    {
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    //Add item to the beginning of the list.
    public void push(Item item)
    {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        size++;
    }

    public int size()
    {
        return size;
    }

    //Iterator for traversing stack items
    public Iterator<Item> iterator()
    {
        return new LinkedStackIterator();
    }

    //inner class to implement iterator interface
    private class LinkedStackIterator implements Iterator<Item>
    {
        private int i = size;
        private Node first = head; //the first node

        public boolean hasNext()
        {
            return (i > 0);
        }

        public Item next()
        {
            Item item = first.item;
            first = first.next;
            i--;
            return item;
        }

        public void remove()
        {
            // not needed
        }
    }
}

class LinkedStackDemo{
    public static void main (String a[])
    {
        Stack <Integer> s = new LinkedStack<Integer>();
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        s.push(70);

        System.out.println("Size of the stack: " + s.size());

        // iterate through stack
        System.out.println("Stack contains following items till this moment:");
        for (Integer i : s)
            System.out.println(i);
        s.pop();
        System.out.println("Stack contains following items till this moment:");
        for (Integer i : s)
            System.out.println(i);
        
    }
}
