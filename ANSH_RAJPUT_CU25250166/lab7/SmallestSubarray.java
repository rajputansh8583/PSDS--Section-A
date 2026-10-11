import java.util.*;

public class SmallestSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int left = 0;
        long sum = 0;
        int minLength = n + 1;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left++];
            }
        }

        if (minLength == n + 1)
            System.out.println("Output: -1");
        else
            System.out.println("Output: " + minLength);

        sc.close();
    }
}