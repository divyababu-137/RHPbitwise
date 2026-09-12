import java.io.*;
import java.util.*;

public class Main {

    static class Bus {
        long s, t;

        Bus(long s, long t) {
            this.s = s;
            this.t = t;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();
        long l = fs.nextLong();
        long x = fs.nextLong();
        long y = fs.nextLong();

        Bus[] buses = new Bus[n];

        for (int i = 0; i < n; i++) {
            long s = fs.nextLong();
            long t = fs.nextLong();
            buses[i] = new Bus(s, t);
        }

        long[] p = new long[m];

        for (int i = 0; i < m; i++) {
            p[i] = fs.nextLong();
        }

        Arrays.sort(buses, Comparator.comparingLong(a -> a.s));

        Integer[] order = new Integer[m];
        for (int i = 0; i < m; i++) {
            order[i] = i;
        }

        Arrays.sort(order, Comparator.comparingLong(i -> p[i]));

        double[] ans = new double[m];

        for (int i = 0; i < m; i++) {
            ans[i] = (double) (l - p[i]) / y;
        }

        PriorityQueue<double[]> pq =
                new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));

        for (Bus bus : buses) {
            double value = (double) bus.t / x + (double) (l - bus.t) / y;
            double start = (double) bus.s / x;

            pq.offer(new double[]{value, start, bus.s});
        }

        for (int idx : order) {
            long pos = p[idx];

            for (Bus bus : buses) {
                if (bus.s > pos) {
                    double wait = (double) (bus.s - pos) / y;
                    double ride = (double) (bus.t - bus.s) / x;
                    double walk = (double) (l - bus.t) / y;

                    ans[idx] = Math.min(ans[idx], wait + ride + walk);
                }
            }
        }

        StringBuilder out = new StringBuilder();

        for (double v : ans) {
            out.append(String.format(Locale.US, "%.10f%n", v));
        }

        System.out.print(out);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long res = 0;

            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }

            return res * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}