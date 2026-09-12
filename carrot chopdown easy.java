import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int ans = 0;

            // Try every possible x
            for (int x = 1; x <= m; x++) {

                int count = 0;

                for (int i = 0; i < n; i++) {

                    // Every carrot >= x gives one carrot of length x
                    if (a[i] >= x) {
                        count++;
                    }

                    // A carrot of length 2*x becomes x + x
                    if (a[i] == 2 * x) {
                        count++;
                    }
                }

                ans = Math.max(ans, count);
            }

            System.out.println(ans);
        }

        sc.close();
    }
}