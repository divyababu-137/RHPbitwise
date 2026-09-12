import java.util.*;

public class Main {

    // Find the first position where arr[index] >= target
    static int lowerBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Find the first position where arr[index] > target
    static int upperBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = (left + right) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];

        // Read A
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // Read B
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        // Read C
        for (int i = 0; i < N; i++) {
            C[i] = sc.nextInt();
        }

        // Sort all three arrays
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);

        long answer = 0;

        // Take every B as the middle part
        for (int i = 0; i < N; i++) {

            int b = B[i];

            // Number of A values < b
            int countA = lowerBound(A, b);

            // Number of C values > b
            int countC = N - upperBound(C, b);

            // Number of altars using this B
            answer += (long) countA * countC;
        }

        System.out.println(answer);

        sc.close();
    }
}