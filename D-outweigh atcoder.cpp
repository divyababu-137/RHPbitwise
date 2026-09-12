import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] A = new long[N];
        long[] B = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextLong();
        }

        long am = 0;
        long bm = 0;

        // Calculate total advantages
        for (int i = 0; i < N; i++) {

            if (A[i] > B[i]) {
                am += A[i] - B[i];
            } 
            else if (B[i] > A[i]) {
                bm += B[i] - A[i];
            }
        }

        // A has no advantage anywhere
        if (am == 0) {
            System.out.println("No");
            return;
        }

        // Weight for A-advantage positions
        long amweight = (bm / am) + 6;

        System.out.println("Yes");

        // Construct W
        for (int i = 0; i < N; i++) {

            if (A[i] > B[i]) {
                System.out.print(amweight + " ");
            } 
            else {
                System.out.print(A[i]);
            }
        }

        System.out.println();
    }
}