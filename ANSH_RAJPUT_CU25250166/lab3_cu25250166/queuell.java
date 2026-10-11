class queuell {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node front = null, rear = null;

    void enqueue(int x) {
        Node n = new Node(x);

        if (rear == null) {
            front = rear = n;
        } else {
            rear.next = n;
            rear = n;
        }

        System.out.println("Enqueued: " + x);
    }

    void dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println("Dequeued: " + front.data);
            front = front.next;

            if (front == null) {
                rear = null;
            }
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.dequeue();
        q.dequeue();
    }
}