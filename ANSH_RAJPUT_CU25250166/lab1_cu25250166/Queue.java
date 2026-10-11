package ANSH_RAJPUT_CU25250166.lab1_cu25250166;
class Queue {
    int[] queue = new int[5];
    int front = 0, rear = -1;

    void enqueue(int x) {
        if (rear == 4) {
            System.out.println("Queue Overflow");
        } else {
            queue[++rear] = x;
        }
    }

    void dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println("Deleted: " + queue[front++]);
        }
    }

    void display() {
        if (front > rear) {
            System.out.println("Queue is empty");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();
        q.dequeue();
    }
}
