package main.java;

public class Queue {

    public static void main(String[] args) {
        
        Queue q = new Queue();
        
        // deQueue is not possible on empty queue
        System.out.println("\ndeQueue from empty queue:");
        q.deQueue();

        // enQueue 5 elements
        System.out.println("\nenQueue 5 elements:");
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        q.display();

        // 6th element can't be added to because the queue is full
        System.out.println("\nInsert 6th element:");
        q.enQueue(6);
        q.display();

        // deQueue removes element entered first i.e. 1
        System.out.println("\nRemove first element:");
        q.deQueue();
        q.display();
    }

    int SIZE = 5;
    int items[] = new int[SIZE];
    int front, rear;

    Queue() {
        front = -1;
        rear = -1;
    }

    boolean isFull() {

        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {

        if (front == -1)
            return true;
        else
            return false;
    }

    void enQueue(int element) {

        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) 
                front = 0;
            rear++;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    int deQueue() {

        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        } else {
            element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else { /* Q has only one element, so we reset the queue after deleting it. */
                front++;
            }
            System.out.println("Deleted -> " + element);
            return (element);
        }
    }

    void display() {

        /* Function to display elements of Queue */
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("\nFront -> " + front);
            System.out.println("Rear  -> " + rear);
            System.out.print("Items -> ");
            for (i = front; i <= rear; i++)
                System.out.print(items[i] + "  ");
            System.out.println();
        }
    }
}