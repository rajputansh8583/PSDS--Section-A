package ANSH_RAJPUT_CU25250166.lab2_cu25250166;
class BinarySearch {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        int key = 30;

        int low = 0, high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == key) {
                System.out.println("Element found at index " + mid);
                return;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Element not found");
    }
}
