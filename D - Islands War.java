import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        // arr[i][0] = left
        // arr[i][1] = right
        int[][] arr = new int[Q][2];

        // Read all requests
        for (int i = 0; i < Q; i++) {

            int lt = sc.nextInt();
            int rt = sc.nextInt();

            arr[i][0] = lt;
            arr[i][1] = rt;
        }

        // Sort according to RIGHT endpoint
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int rtmost = -1;

        for (int i = 0; i < Q; i++) {

            int lt = arr[i][0];  // left
            int rt = arr[i][1];  // right

            if (lt > rtmost) {
                count++;
                rtmost = rt;
            }
        }

        System.out.println(count);

        sc.close();
    }
}