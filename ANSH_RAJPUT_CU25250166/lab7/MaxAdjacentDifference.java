import java.util.*;

public class MaxAdjacentDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        Arrays.sort(a);

        int[] result = new int[n];
        int left = 0, right = n - 1, k = 0;

        // Small and large elements alternately
        while (left <= right) {
            if (k < n)
                result[k++] = a[left++];

            if (k < n)
                result[k++] = a[right--];
        }

        long sum = 0;

        for (int i = 0; i < n - 1; i++)
            sum += Math.abs(result[i] - result[i + 1]);

        System.out.print("Rearranged Array: ");
        for (int x : result)
            System.out.print(x + " ");

        System.out.println("\nMaximum Sum = " + sum);

        sc.close();
    }
}
