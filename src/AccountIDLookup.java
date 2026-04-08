import java.util.*;

public class AccountIDLookup {

    // 🔹 Linear Search (First Occurrence)
    public static int linearFirst(String[] arr, String target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Index: " + i +
                        " | Comparisons: " + comparisons);
                return i;
            }
        }
        return -1;
    }

    // 🔹 Linear Search (Last Occurrence)
    public static int linearLast(String[] arr, String target) {
        int comparisons = 0;
        int lastIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                lastIndex = i;
            }
        }

        System.out.println("Linear Last Index: " + lastIndex +
                " | Comparisons: " + comparisons);
        return lastIndex;
    }

    // 🔹 Binary Search (Find one occurrence)
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println("Binary Found Index: " + mid +
                        " | Comparisons: " + comparisons);
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // 🔹 Count Occurrences using Binary Search
    public static int countOccurrences(String[] arr, String target) {
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);

        if (first == -1) return 0;
        return last - first + 1;
    }

    // First occurrence (Binary)
    public static int firstOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].compareTo(target) == 0) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Last occurrence (Binary)
    public static int lastOccurrence(String[] arr, String target) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].compareTo(target) == 0) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        String target = "accB";

        // 🔸 Linear Search
        linearFirst(logs, target);
        linearLast(logs, target);

        // 🔸 Sort before Binary Search
        Arrays.sort(logs);

        System.out.println("\nSorted Logs: " + Arrays.toString(logs));

        // 🔸 Binary Search
        int index = binarySearch(logs, target);

        int count = countOccurrences(logs, target);
        System.out.println("Count of " + target + ": " + count);
    }
}