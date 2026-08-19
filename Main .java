import java.util.Scanner;

// Custom exception for Queue Overflow
class QueueOverflowException extends Exception {
    QueueOverflowException(String message) {
        super(message);
    }
}

// Custom exception for Queue Underflow
class QueueUnderflowException extends Exception {
    QueueUnderflowException(String message) {
        super(message);
    }
}

// Queue ADT
class Queue {
    int[] queue;
    int front, rear, size;

    Queue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // Insert element
    void enqueue(int value) throws QueueOverflowException {
        if (rear == size - 1) {
            throw new QueueOverflowException("Queue Overflow!");
        }

        if (front == -1) {
            front = 0;
        }

        queue[++rear] = value;
        System.out.println(value + " inserted into queue.");
    }

    // Delete element
    void dequeue() throws QueueUnderflowException {
        if (front == -1 || front > rear) {
            throw new QueueUnderflowException("Queue Underflow!");
        }

        System.out.println(queue[front] + " deleted from queue.");
        front++;

        if (front > rear) {
            front = -1;
            rear = -1;
        }
    }

    // Display queue
    void display() throws QueueUnderflowException {
        if (front == -1) {
            throw new QueueUnderflowException("Queue is empty!");
        }

        System.out.print("Queue elements: ");

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }

        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue q = new Queue(5);

        while (true) {
            System.out.println("\n----- QUEUE ADT -----");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter element: ");
                        int value = sc.nextInt();
                        q.enqueue(value);
                        break;

                    case 2:
                        q.dequeue();
                        break;

                    case 3:
                        q.display();
                        break;

                    case 4:
                        System.out.println("Program terminated.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } 
            catch (QueueOverflowException e) {
                System.out.println("Exception: " + e.getMessage());
            } 
            catch (QueueUnderflowException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
