import java.util.*;

class Main {

    static int N, K;
    static int[] a;

    static void solve(int pos, int sum) {

        if (pos == N) {
            if (sum == K) {
                for (int x : a)
                    System.out.print(x + " ");
                System.out.println();
            }
            return;
        }

        int weight = pos + 1;

        for (int x = 0; sum + weight * x <= K; x++) {

            a[pos] = x;

            solve(pos + 1, sum + weight * x);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        a = new int[N];

        solve(0, 0);
    }
}