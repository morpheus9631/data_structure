package main.java;

public class SinglyLinkedListDel {

    class Node 
    {
        int data;
        Node next;
    
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ------------------------------------------------------------------------
    
    Node head;

    // ------------------------------------------------------------------------
    public void addLast(int data) 
    {
        if (head == null) { 
            this.head = new Node(data);
            return;
        }

        Node curr_node = head;
        while (curr_node.next != null) {
            curr_node = curr_node.next;
        }
        curr_node.next = new Node(data);
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
 
    public void delFirst() {
        if (head == null) {
            System.out.println("Empty list. Nothing to delete.");
            return;
        }
        head = head.next;
    }

    // ------------------------------------------------------------------------

    public void delLast() {
        if (head == null) {
            System.out.println("Empty list. Nothing to delete.");
            return;
        }

        // 串列只有一個節點
        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // ------------------------------------------------------------------------

    public void del(int data) 
    {
        if (head == null) {
            System.out.println("Empty list. Nothing to delete.");
            return;
        }

        if (head.data == data) {
            delFirst();
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Node with data " + data + " not found.");
            return;
        }
        current.next = current.next.next;
    }    

    // ------------------------------------------------------------------------

    public static void main(String[] args) 
    {
        SinglyLinkedListDel list = new SinglyLinkedListDel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.printList();

        list.del(2);
        list.printList();    

        list.delFirst();
        list.printList();

        list.delLast();
        list.printList();
    }
}
