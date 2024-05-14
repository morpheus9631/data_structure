package main.java;

public class DoublyLinkedListAdd {

    class Node {
        int data;
        Node prev;
        Node next;
    
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // ------------------------------------------------------------------------
    
    Node head = null;
    Node tail = null;

    // ------------------------------------------------------------------------

    public void addFirst(int data) 
    {
        Node newNode = new Node(data);
        
        if (tail == null) {
            head = tail = newNode; // 串列是空的
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // ------------------------------------------------------------------------

    public void addLast(int data) 
    {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode; // 空串列
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }        
    }

    // ------------------------------------------------------------------------

    public void add(int position, int data) 
    {
        if (position <= 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        int index = 0;
        Node current = head;
        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null) {
            addLast(data);
            return;
        }

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }    

    // ------------------------------------------------------------------------

    public void printList() {
        StringBuilder sb = new StringBuilder();

        Node current = head;
        while (current != null) {
            if (sb.length() > 0) sb.append(" -> ");
            sb.append(String.format("{data: %d}", current.data));
            current = current.next;
        }
        
        System.out.println(sb.toString());
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        DoublyLinkedListAdd list = new DoublyLinkedListAdd();

        list.addLast(1);
        list.printList();

        list.addFirst(2);
        list.printList();

        list.add(2, 3);
        list.printList();
    }    
}



