package LinkedListPrograms;

import java.util.Iterator;

/**
 * Created by Goutam on 9/7/2017.
 */

interface Queue <Item> extends Iterable <Item> {
    Item delete(); // return the top item and removes it from stack
    void insert(Item item); // adds an item to the stack
    boolean isEmpty(); // returns true if stack is empty, false otherwise
    int size();  // returns the number of items in stack right now
}

class QueueUsingLL <Item> implements Queue <Item> {
    private Node head; //the first node
    private Node currentNode;
    private Node previousNode = head;
    private int size; // number of items

    //nested class to define node
    private class Node
    {
        Item item;
        Node next;
    }

    //Zero argument constructor
    public QueueUsingLL()
    {
        head = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    //Remove item from the beginning of the list.
    public Item delete()
    {
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    //Add item to the beginning of the list.
    public void insert(Item item)
    {
        currentNode = new Node();
        currentNode.item = item;
        currentNode.next = null;
        
        if(head == null){
            head = currentNode;
            previousNode = currentNode;
            size++;
        } else {
            previousNode.next = currentNode;
            previousNode = currentNode;
            size++;
        }
    }

    public int size()
    {
        return size;
    }

    //Iterator for traversing stack items
    public Iterator<Item> iterator()
    {
        return new QueueUsingLLIterator();
    }

    //inner class to implement iterator interface
    private class QueueUsingLLIterator implements Iterator<Item>
    {
        private int i = size;
        private int j = 0;
        private Node first = head; //the first node

        public boolean hasNext()
        {
            return (j < i);
        }

        public Item next()
        {
            Item item = first.item;
            first = first.next;
            j++;
            return item;
        }

        public void remove()
        {
            // not needed
        }
    }
}

class QueueUsingLLDemo{
    public static void main (String a[])
    {
        Queue <Integer> s = new QueueUsingLL<Integer>();
        s.insert(20);
        s.insert(30);
        s.insert(40);
        s.insert(50);
        s.insert(60);
        s.insert(70);

        System.out.println("Size of the Queue: " + s.size());

        // iterate through queue
        System.out.print("Queue contains following items till this moment: ");
        for (Integer i : s)
            System.out.print(i + " ");
        s.delete();
        System.out.print("\nQueue contains following items till this moment: ");
        for (Integer i : s)
            System.out.print(i + " ");

    }
}
