import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int N = sc.nextInt();

            long[] A = new long[N];
            long[] B = new long[N];

            long base = 0;
            long minA = Long.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextLong();
                base += A[i];
                minA = Math.min(minA, A[i]);
            }

            for (int i = 0; i < N; i++) {
                B[i] = sc.nextLong();
            }

            long[] savings = new long[N];

            for (int i = 0; i < N; i++) {
                savings[i] = A[i] - B[i];
            }

            Arrays.sort(savings);

            long answer = base;
            long saved = 0;

            for (int m = 1; m <= N; m++) {

                saved += savings[N - m];

                long extra = Math.max(0, 2L * m - N);

                long cost = base - saved + extra * minA;

                answer = Math.min(answer, cost);
            }

            System.out.println(answer);
        }

        sc.close();
    }
}