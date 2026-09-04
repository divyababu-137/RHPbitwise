import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long K = sc.nextLong();

        long[] A = new long[N];
        boolean[] eaten = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        long sum = 0;

        for (int i = 0; i < N; i++) {

            // Remove the day that is now outside the last M days
            if (i - M >= 0 && eaten[i - M]) {
                sum -= A[i - M];
            }

            // Try eating today's snack
            if (sum + A[i] <= K) {
                eaten[i] = true;
                sum += A[i];
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}