public class RiskThresholdLookup {

    // 🔹 Linear Search (Unsorted)
    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: Found at index " + i +
                        " | Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Linear: Not found | Comparisons: " + comparisons);
        return -1;
    }

    // 🔹 Binary Search (Find insertion point)
    public static int binaryInsertion(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                System.out.println("Binary: Found at index " + mid +
                        " | Comparisons: " + comparisons);
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary: Not found, insertion index = " + low +
                " | Comparisons: " + comparisons);
        return low; // insertion point
    }

    // 🔹 Floor (largest ≤ target)
    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                result = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // 🔹 Ceiling (smallest ≥ target)
    public static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] > target) {
                result = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] unsorted = {50, 10, 100, 25}; // unsorted
        int[] sorted = {10, 25, 50, 100};   // sorted

        int target = 30;

        // 🔸 Linear Search
        linearSearch(unsorted, target);

        // 🔸 Binary Search (Insertion Point)
        int index = binaryInsertion(sorted, target);

        // 🔸 Floor & Ceiling
        int f = floor(sorted, target);
        int c = ceiling(sorted, target);

        System.out.println("Floor(" + target + "): " + f);
        System.out.println("Ceiling(" + target + "): " + c);
    }
}