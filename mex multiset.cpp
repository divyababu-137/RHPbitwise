import java.util.*;

public class Main {

    public static void solve(Scanner sc) {

        int N = sc.nextInt();

        int[] arr = new int[N];

        ArrayList<Integer> zi = new ArrayList<>();

        // Read the array
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();

            // Store the positions where value is 0
            if (arr[i] == 0) {
                zi.add(i);
            }
        }

        // If there is exactly one zero, answer is NO
        if (zi.size() == 1) {
            System.out.println("NO");
            return;
        }

        // Initially put every element in C
        char[] s = new char[N];
        Arrays.fill(s, 'C');

        // If there is at least one zero
        if (zi.size() > 0) {

            // First zero goes to B
            int firstIndex = zi.get(0);
            s[firstIndex] = 'B';

            // All remaining zeros go to A
            for (int i = 1; i < zi.size(); i++) {
                int index = zi.get(i);
                s[index] = 'A';
            }
        }

        System.out.println("YES");
        System.out.println(new String(s));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            solve(sc);
        }

        sc.close();
    }
}