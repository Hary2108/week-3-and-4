class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + ":" + riskScore + " (Bal:" + accountBalance + ")";
    }
}

public class ClientRiskScoreRanking {

    // 🔹 Bubble Sort (Ascending by riskScore)
    public static int bubbleSort(Client[] arr) {
        int n = arr.length;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    // swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapCount++;
                }
            }
        }
        return swapCount;
    }

    // 🔹 Insertion Sort (Descending by riskScore, then accountBalance)
    public static void insertionSort(Client[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && (
                    arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore && arr[j].accountBalance < key.accountBalance)
            )) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // 🔹 Print Top K High Risk Clients
    public static void printTopK(Client[] arr, int k) {
        System.out.println("Top " + k + " High Risk Clients:");
        for (int i = 0; i < Math.min(k, arr.length); i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 3000),
                new Client("clientB", 50, 4000)
        };

        // 🔸 Bubble Sort (Ascending)
        Client[] bubbleArray = clients.clone();
        int swaps = bubbleSort(bubbleArray);

        System.out.println("Bubble Sort (Ascending):");
        for (Client c : bubbleArray) {
            System.out.print(c + " ");
        }
        System.out.println("\nSwaps: " + swaps);

        // 🔸 Insertion Sort (Descending)
        Client[] insertionArray = clients.clone();
        insertionSort(insertionArray);

        System.out.println("\nInsertion Sort (Descending):");
        for (Client c : insertionArray) {
            System.out.print(c + " ");
        }

        // 🔸 Top 10 (or less)
        System.out.println();
        printTopK(insertionArray, 10);
    }
}