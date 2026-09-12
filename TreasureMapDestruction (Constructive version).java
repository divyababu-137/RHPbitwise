import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            int[] diff = new int[n + 1];

            for (int i = 0; i < n; i++) {

                int x = b[i];

                if (x > 0) {

                    int left = Math.max(0, i - x + 1);
                    int right = Math.min(n, i + x);

                    diff[left]++;
                    diff[right]--;
                }
            }

            boolean[] restricted = new boolean[n];

            int count = 0;

            for (int i = 0; i < n; i++) {

                count += diff[i];

                if (count > 0) {
                    restricted[i] = true;
                }
            }

            boolean possible = true;

            for (int i = 0; i < n; i++) {

                if (b[i] >= 0) {

                    int x = b[i];

                    boolean leftPossible = false;
                    boolean rightPossible = false;

                    
                    if (i - x >= 0) {
                        if (!restricted[i - x]) {
                            leftPossible = true;
                        }
                    }

                    if (i + x < n) {
                        if (!restricted[i + x]) {
                            rightPossible = true;
                        }
                    }

                   if (!leftPossible && !rightPossible) {
                        possible = false;
                        break;
                    }
                }
            }

            if (!possible) {

                System.out.println(-1);

            } else {

                for (int i = 0; i < n; i++) {

                    if (restricted[i]) {
                        System.out.print(0);
                    } else {
                        System.out.print(1);
                    }
                }

                System.out.println();
            }
        }

        sc.close();
    }
}