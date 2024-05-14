package main.java;

public class DoublyLinkedListDel {

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

    public void addLast(int data) 
    {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }        
    }

    // ------------------------------------------------------------------------

    public void delFirst() {
        if (head == null) {
            System.out.println("Empty list. Nothing to delete.");
            return;
        }

        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // 串列只有一個節點
        }
    }

    // ------------------------------------------------------------------------

    public void delLast() 
    {
        if (head == null) {
            System.out.println("Empty list. Nothing to delete.");
            return;
        }

        // 串列只有一個節點
        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    // ------------------------------------------------------------------------

    public void del(int data) 
    {
        if (head == null) {
            System.out.println("Empty list. Nothing to delete.");
            return;
        }

        //  第一個節點就是目標
        if (head.data == data) {
            delFirst();
            return;
        }
        
        //  找目標
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        
        // 找不到目標
        if (current == null) {
            System.out.println("Node with data " + data + " not found.");
            return;
        }
        
        // 目標是最後一個節點
        if (current == tail) {
            delLast();
            return;
        }
        
        current.prev.next = current.next;
        current.next.prev = current.prev;
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
        
        DoublyLinkedListDel list = new DoublyLinkedListDel();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.printList();

        list.del(2);
        list.printList();

        list.delFirst();
        list.printList();

        list.delLast();
        list.printList();
    }    


}
