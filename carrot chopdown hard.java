import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] a = new int[n];

            long total = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                total += a[i];
            }

            long[] answer = new long[m + 1];

            for (int k = 1; k <= m; k++) {

                long limit = 1L << k;

                if (limit > m) {
                    answer[k] = total;
                    continue;
                }

                long best = 0;

                int maxX = (int)(m / limit);

                for (int x = 1; x <= maxX; x++) {

                    long current = 0;

                    for (int i = 0; i < n; i++) {

                        if (a[i] == limit * x) {
                            current += limit;
                        } else {
                            current += Math.min(a[i] / x, limit - 1);
                        }
                    }

                    best = Math.max(best, current);
                }

                answer[k] = best;
            }

            for (int k = 1; k <= m; k++) {
                System.out.print(answer[k] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}