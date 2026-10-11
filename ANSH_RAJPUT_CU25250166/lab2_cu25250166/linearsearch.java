package ANSH_RAJPUT_CU25250166.lab2_cu25250166;

class LinearSearch {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50};
        int key = 30;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                System.out.println("Element found at index " + i);
                return;
            }
        }

        System.out.println("Element not found");
    }
}
