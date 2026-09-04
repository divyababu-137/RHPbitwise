import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int K = sc.nextInt();

        String[] s = new String[H];

        boolean[] row = new boolean[H];
        boolean[] col = new boolean[W];

        for (int i = 0; i < H; i++) {
            s[i] = sc.next();

            for (int j = 0; j < W; j++) {
                if (s[i].charAt(j) == '#') {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        int[][] dist = new int[H][W];

        for (int i = 0; i < H; i++)
            Arrays.fill(dist[i], -1);

        Queue<int[]> q = new LinkedList<>();

        // Find safe cells
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {

                if (s[i].charAt(j) == '.' && !row[i] && !col[j]) {
                    dist[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // BFS
        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            if (dist[r][c] == K)
                continue;

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= H || nc < 0 || nc >= W)
                    continue;

                if (s[nr].charAt(nc) == '#')
                    continue;

                if (dist[nr][nc] != -1)
                    continue;

                dist[nr][nc] = dist[r][c] + 1;
                q.add(new int[]{nr, nc});
            }
        }

        int ans = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (dist[i][j] != -1)
                    ans++;
            }
        }

        System.out.println(ans);
    }
}