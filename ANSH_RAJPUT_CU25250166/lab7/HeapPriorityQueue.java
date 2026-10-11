import java.util.Scanner;

class Heap {
    int[] heap;
    int size = 0;
    boolean minHeap;

    Heap(int n, boolean minHeap) {
        heap = new int[n];
        this.minHeap = minHeap;
    }

    void insert(int value) {
        heap[size] = value;
        int i = size++;

        while (i > 0) {
            int p = (i - 1) / 2;

            if ((minHeap && heap[i] < heap[p]) ||
                (!minHeap && heap[i] > heap[p])) {
                int temp = heap[i];
                heap[i] = heap[p];
                heap[p] = temp;
                i = p;
            } else break;
        }
    }

    int deleteRoot() {
        int root = heap[0];
        heap[0] = heap[--size];

        int i = 0;

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int best = i;

            if (left < size &&
                ((minHeap && heap[left] < heap[best]) ||
                 (!minHeap && heap[left] > heap[best])))
                best = left;

            if (right < size &&
                ((minHeap && heap[right] < heap[best]) ||
                 (!minHeap && heap[right] > heap[best])))
                best = right;

            if (best == i) break;

            int temp = heap[i];
            heap[i] = heap[best];
            heap[best] = temp;
            i = best;
        }

        return root;
    }

    void display() {
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
}

public class HeapPriorityQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Max Heap
        Heap max = new Heap(n, false);

        System.out.println("Enter elements for Max Heap:");
        for (int i = 0; i < n; i++)
            max.insert(sc.nextInt());

        System.out.print("Max Heap: ");
        max.display();

        // Min Heap
        Heap min = new Heap(n, true);

        System.out.println("Enter elements for Min Heap:");
        for (int i = 0; i < n; i++)
            min.insert(sc.nextInt());

        System.out.print("Min Heap: ");
        min.display();

        // Priority Queue
        System.out.println("Priority Queue (Min Heap):");
        while (min.size > 0)
            System.out.print(min.deleteRoot() + " ");

        // Heap Sort
        System.out.println("\n\nEnter array size:");
        int m = sc.nextInt();

        int[] a = new int[m];

        System.out.println("Enter array elements:");
        for (int i = 0; i < m; i++)
            a[i] = sc.nextInt();

        // Heap Sort using Priority Queue
        Heap sortHeap = new Heap(m, true);

        for (int x : a)
            sortHeap.insert(x);

        for (int i = 0; i < m; i++)
            a[i] = sortHeap.deleteRoot();

        System.out.print("Sorted Array: ");
        for (int x : a)
            System.out.print(x + " ");

        sc.close();
    }
}