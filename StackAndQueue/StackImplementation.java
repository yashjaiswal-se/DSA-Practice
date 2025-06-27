import java.util.Stack;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class StackImplementation {

    // Main method with implementation choice
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose stack implementation:");
        System.out.println("1. Stack using Java Library (Stack<T>)");
        System.out.println("2. Stack using Array");
        System.out.println("3. Stack using ArrayList");
        System.out.println("4. Stack using Linked List");

        System.out.print("Enter your choice: ");
        int option = sc.nextInt();
        sc.close();

        switch (option) {
            case 1:
                stackLibraryImplementation();
                break;
            case 2:
                stackArrayImplementation();
                break;
            case 3:
                stackArrayListImplementation();
                break;
            case 4:
                stackLinkedListImplementation();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    // Shared menu method
    public static int makeChoice(Scanner sc) {
        System.out.println("\nOptions for stack operation are:");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Top");
        System.out.println("4. isEmpty");
        System.out.println("5. Size");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    // Library Stack Implementation (using java.util.Stack)
    public static void stackLibraryImplementation() {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            choice = makeChoice(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int ele = sc.nextInt();
                    stack.push(ele);
                    System.out.println("Stack after operation: " + stack);
                    break;

                case 2:
                    if (!stack.isEmpty()) {
                        System.out.println("Popped element: " + stack.pop());
                    } else {
                        System.out.println("Stack is empty. Nothing to pop.");
                    }
                    System.out.println("Stack after operation: " + stack);
                    break;

                case 3:
                    if (!stack.isEmpty()) {
                        System.out.println("Top element is: " + stack.peek());
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Is stack empty? " + stack.isEmpty());
                    break;

                case 5:
                    System.out.println("Stack size is: " + stack.size());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Array-based Stack Implementation
    public static void stackArrayImplementation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size for the stack: ");
        int size = sc.nextInt();
        int[] stack = new int[size];
        int sp = -1; // Stack pointer
        int choice;

        while (true) {
            choice = makeChoice(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int ele = sc.nextInt();
                    if (sp == size - 1) {
                        System.out.println("Stack overflow");
                    } else {
                        stack[++sp] = ele;
                        displayStack(stack, sp);
                    }
                    break;

                case 2:
                    if (!isEmpty(sp)) {
                        System.out.println("Popped element: " + stack[sp]);
                        sp--;
                        displayStack(stack, sp);
                    } else {
                        System.out.println("Stack is empty. Nothing to pop.");
                    }
                    break;

                case 3:
                    if (!isEmpty(sp)) {
                        System.out.println("Top element is: " + stack[sp]);
                        displayStack(stack, sp);
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Is stack empty? " + isEmpty(sp));
                    break;

                case 5:
                    System.out.println("Stack size is: " + (sp + 1));
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ArrayList-based Stack Implementation
    public static void stackArrayListImplementation() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> stack = new ArrayList<>();
        int choice;

        while (true) {
            choice = makeChoice(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int ele = sc.nextInt();
                    stack.add(ele);
                    System.out.println("Stack after operation: " + stack);
                    break;

                case 2:
                    if (!stack.isEmpty()) {
                        System.out.println("Popped element: " + stack.remove(stack.size() - 1));
                        System.out.println("Stack after operation: " + stack);
                    } else {
                        System.out.println("Stack is empty. Nothing to pop.");
                    }
                    break;

                case 3:
                    if (!stack.isEmpty()) {
                        System.out.println("Top element is: " + stack.get(stack.size() - 1));
                        System.out.println("Stack after operation: " + stack);
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Is stack empty? " + stack.isEmpty());
                    break;

                case 5:
                    System.out.println("Stack size is: " + stack.size());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Deque based Stack Implementation
    public static void stackDequeImplementation() {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        int choice;

        while (true) {
            choice = makeChoice(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int ele = sc.nextInt();
                    stack.push(ele); // Push to top
                    System.out.println("Stack after operation: " + stack);
                    break;

                case 2:
                    if (!stack.isEmpty()) {
                        System.out.println("Popped element: " + stack.pop()); // Pop from top
                        System.out.println("Stack after operation: " + stack);
                    } else {
                        System.out.println("Stack is empty. Nothing to pop.");
                    }
                    break;

                case 3:
                    if (!stack.isEmpty()) {
                        System.out.println("Top element is: " + stack.peek()); // Peek at top
                        System.out.println("Stack after operation: " + stack);
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Is stack empty? " + stack.isEmpty());
                    break;

                case 5:
                    System.out.println("Stack size is: " + stack.size());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Linked List based Stack Implementation
    public static void stackLinkedListImplementation() {
        Scanner sc = new Scanner(System.in);
        LinkedListStack stack = new LinkedListStack();
        int choice;

        while (true) {
            choice = makeChoice(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int ele = sc.nextInt();
                    stack.push(ele);
                    stack.printStack();
                    break;

                case 2:
                    if (!stack.isEmpty()) {
                        System.out.println("Popped element: " + stack.pop());
                        stack.printStack();
                    } else {
                        System.out.println("Stack is empty. Nothing to pop.");
                    }
                    break;

                case 3:
                    if (!stack.isEmpty()) {
                        System.out.println("Top element is: " + stack.peek());
                        stack.printStack();
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Is stack empty? " + stack.isEmpty());
                    break;

                case 5:
                    System.out.println("Stack size is: " + stack.size());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper method for displaying array-based stack
    public static void displayStack(int[] stack, int sp) {
        System.out.print("Stack after operation: ");
        if (sp == -1) {
            System.out.println("[empty]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i <= sp; i++) {
            System.out.print(stack[i]);
            if (i < sp)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    // Helper method for checking if array-based stack is empty
    public static boolean isEmpty(int top) {
        return top == -1;
    }

    // Node class for Linked List
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // LinkedList Stack class
    static class LinkedListStack {
        private Node top;
        private int size;

        public LinkedListStack() {
            this.top = null;
            this.size = 0;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
            size++;
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            int poppedData = top.data;
            top = top.next;
            size--;
            return poppedData;
        }

        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public int size() {
            return size;
        }

        public void printStack() {
            System.out.print("Stack after operation: ");
            if (isEmpty()) {
                System.out.println("[empty]");
                return;
            }
            Node current = top;
            System.out.print("[");
            while (current != null) {
                System.out.print(current.data);
                if (current.next != null)
                    System.out.print(", ");
                current = current.next;
            }
            System.out.println("]");
        }
    }

}
