import java.util.*;

public class QueueImplementation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose queue implementation:");
        System.out.println("1. Queue using Java Library (LinkedList)");
        System.out.println("2. Queue using Array");
        System.out.println("3. Queue using ArrayList");
        System.out.println("4. Queue using Linked List (Custom)");
        System.out.println("5. Queue using Deque");

        System.out.print("Enter your choice: ");
        int option = sc.nextInt();

        switch (option) {
            case 1 -> queueLibraryImplementation();
            case 2 -> queueArrayImplementation();
            case 3 -> queueArrayListImplementation();
            case 4 -> queueLinkedListImplementation();
            case 5 -> queueDequeImplementation();
            default -> System.out.println("Invalid option.");
        }
        sc.close();
    }

    public static int makeChoice(Scanner sc) {
        System.out.println("\nOptions:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Peek (Front)");
        System.out.println("4. isEmpty");
        System.out.println("5. Size");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    // 1. Queue using Java Library (LinkedList)
    public static void queueLibraryImplementation() {
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            choice = makeChoice(sc);
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element to enqueue: ");
                    queue.add(sc.nextInt());
                    System.out.println("Queue: " + queue);
                }
                case 2 -> {
                    if (!queue.isEmpty()) {
                        System.out.println("Dequeued: " + queue.remove());
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    System.out.println("Queue: " + queue);
                }
                case 3 -> System.out.println(queue.isEmpty() ? "Queue is empty." : "Front: " + queue.peek());
                case 4 -> System.out.println("Is queue empty? " + queue.isEmpty());
                case 5 -> System.out.println("Queue size: " + queue.size());
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // 2. Queue using Array
    public static void queueArrayImplementation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size for the queue: ");
        int size = sc.nextInt();
        int[] queue = new int[size];
        int front = -1, rear = -1;

        while (true) {
            int choice = makeChoice(sc);
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element to enqueue: ");
                    int ele = sc.nextInt();
                    if (rear == size - 1) {
                        System.out.println("Queue Overflow");
                    } else {
                        if (front == -1)
                            front = 0;
                        queue[++rear] = ele;
                        displayQueue(queue, rear, front);
                    }
                }
                case 2 -> {
                    if (front == -1 || front > rear) {
                        System.out.println("Queue Underflow");
                        front = rear = -1;
                    } else {
                        System.out.println("Dequeued: " + queue[front]);
                        queue[front++] = 0;
                        if (front > rear)
                            front = rear = -1;
                    }
                }
                case 3 -> {
                    if (front != -1 && front <= rear)
                        System.out.println("Front element: " + queue[front]);
                    else
                        System.out.println("Queue is empty.");
                }
                case 4 -> System.out.println("Is queue empty? " + isEmpty(front, rear));
                case 5 -> System.out.println("Queue size: " + (isEmpty(front, rear) ? 0 : (rear - front + 1)));
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // 3. Queue using ArrayList
    public static void queueArrayListImplementation() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> queue = new ArrayList<>();

        while (true) {
            int choice = makeChoice(sc);
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element to enqueue: ");
                    queue.add(sc.nextInt());
                    System.out.println("Queue: " + queue);
                }
                case 2 -> {
                    if (!queue.isEmpty()) {
                        System.out.println("Dequeued: " + queue.remove(0));
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    System.out.println("Queue: " + queue);
                }
                case 3 -> System.out.println(queue.isEmpty() ? "Queue is empty." : "Front: " + queue.get(0));
                case 4 -> System.out.println("Is queue empty? " + queue.isEmpty());
                case 5 -> System.out.println("Queue size: " + queue.size());
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // 4. Queue using LinkedList (custom implementation)
    public static void queueLinkedListImplementation() {
        Scanner sc = new Scanner(System.in);
        LinkedListQueue queue = new LinkedListQueue();

        while (true) {
            int choice = makeChoice(sc);
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element to enqueue: ");
                    queue.enqueue(sc.nextInt());
                    queue.printQueue();
                }
                case 2 -> {
                    if (!queue.isEmpty()) {
                        System.out.println("Dequeued: " + queue.dequeue());
                        queue.printQueue();
                    } else {
                        System.out.println("Queue is empty.");
                    }
                }
                case 3 -> System.out.println(queue.isEmpty() ? "Queue is empty." : "Front: " + queue.peek());
                case 4 -> System.out.println("Is queue empty? " + queue.isEmpty());
                case 5 -> System.out.println("Queue size: " + queue.size());
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // 5. Queue using Deque
    public static void queueDequeImplementation() {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> queue = new ArrayDeque<>();

        while (true) {
            int choice = makeChoice(sc);
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element to enqueue: ");
                    queue.offerLast(sc.nextInt());
                    System.out.println("Queue: " + queue);
                }
                case 2 -> {
                    if (!queue.isEmpty()) {
                        System.out.println("Dequeued: " + queue.pollFirst());
                        System.out.println("Queue: " + queue);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                }
                case 3 -> System.out.println(queue.isEmpty() ? "Queue is empty." : "Front: " + queue.peekFirst());
                case 4 -> System.out.println("Is queue empty? " + queue.isEmpty());
                case 5 -> System.out.println("Queue size: " + queue.size());
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // Helper Methods
    public static void displayQueue(int[] queue, int rear, int front) {
        System.out.print("Queue: [");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i]);
            if (i < rear)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static boolean isEmpty(int front, int rear) {
        return front == -1 || front > rear;
    }

    // Node class for linked list queue
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Custom linked list queue implementation
    static class LinkedListQueue {
        private Node front, rear;
        private int size;

        public void enqueue(int data) {
            Node node = new Node(data);
            if (rear != null)
                rear.next = node;
            rear = node;
            if (front == null)
                front = node;
            size++;
        }

        public int dequeue() {
            if (isEmpty())
                throw new NoSuchElementException();
            int val = front.data;
            front = front.next;
            if (front == null)
                rear = null;
            size--;
            return val;
        }

        public int peek() {
            if (isEmpty())
                throw new NoSuchElementException();
            return front.data;
        }

        public boolean isEmpty() {
            return front == null;
        }

        public int size() {
            return size;
        }

        public void printQueue() {
            Node curr = front;
            System.out.print("Queue: [");
            while (curr != null) {
                System.out.print(curr.data);
                if (curr.next != null)
                    System.out.print(", ");
                curr = curr.next;
            }
            System.out.println("]");
        }
    }
}
