package main.java;

public class SinglyLinkedListAdd {

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

    public void addFirst(int data) 
    {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    // ------------------------------------------------------------------------

    public void add(int position, int data) 
    {
        if (position < 0) {
            addFirst(data);
            return;
        }

        if (position == 0) {
            addFirst(data);
            return ;
        }

        Node new_node = new Node(data);
        Node curr_node = head;
        int  curr_index = 0;

        while(curr_node != null && curr_index < position -1) {
            curr_node = curr_node.next;
            curr_index += 1;
        }

        if (curr_node == null) {
            addLast(data);
            return;
        }

        new_node.next = curr_node.next;
        curr_node.next = new_node;
    }

    // ------------------------------------------------------------------------

    public String toString() {
        
        StringBuilder builder = new StringBuilder();

        Node curr_node = this.head;
        while (curr_node != null) {
            if (builder.length() > 0) builder.append(" -> ");
            builder.append(String.format("{data:%d}", curr_node.data));
            curr_node = curr_node.next;
        }
        return builder.toString();
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        
        SinglyLinkedListAdd list = new SinglyLinkedListAdd();
        System.out.println(list.toString());

        list.addLast(1);
        System.out.println(list.toString());

        list.addFirst(2);
        System.out.println(list.toString());

        list.add(1, 3);
        System.out.println(list.toString());
    }
}

