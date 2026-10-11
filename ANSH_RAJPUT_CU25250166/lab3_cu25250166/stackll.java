package ANSH_RAJPUT_CU25250166.lab3_cu25250166;
class StackLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node top = null;

    void push(int x) {
        Node n = new Node(x);
        n.next = top;
        top = n;

        System.out.println("Pushed: " + x);
    }

    void pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println("Popped: " + top.data);
            top = top.next;
        }
    }

    public static void main(String[] args) {
        StackLL s = new StackLL();

        s.push(10);
        s.push(20);
        s.push(30);

        s.pop();
        s.pop();
    }
}
