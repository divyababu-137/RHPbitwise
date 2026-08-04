/*import java.util.*;
public class Main{
	public static void join(int[] ldr, int lt, int rt){
        int lLdr = find(ldr, lt);
        int rLdr = find(ldr, rt);
        ldr[rLdr] = lLdr;
    }
    private static int find(int[] ldr, int node){
        if(ldr[node] != node){
            ldr[node] = find(ldr, ldr[node]);
        }
        return ldr[node];
    }
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ldr = new int[n+1];
        int[] grpcnt = new int[n+1];
        int[] ecnt = new int[n+1];
        int[] edg = new int[m];
        for(int i=1;i<=n;i++){
        	ldr[i]=i;
        }
        for(int j=1;j<=n;j++){
        	grpcnt[j]=0;
        }
        for(int c=1;c<=n;c++){
        	ecnt[c]=0;
        }
        for(int k=1;k<=n;k++){
        	edg[k]=0;
        }
        for(int e=0;e<m;e++){
        	int lt = sc.nextInt();
        	int rt = sc.nextInt();
        	edg[e]={lt,rt};
        	join(ldr, lt, rt);
        }
        for(int node=1;node<=n;node++){
        	int uldr=find(ldr,node);
        	grpcnt[uldr]++;
        }
        for(auto[lt,rt]:edges){
        	int uldr=find(ldr,rt);
        	ecnt[uldr]++;
        }
        long ans = 0;
        for(int node=1;node<=n;node++){
        	int ncnt=grpcnt[node];
        	ans+=((ncnt*(ncnt-1))/2-ecnt[node]);
        }
        System.out.println(ans);
        
        
        
    }
}*/
import java.util.*;

public class Main {

    static class Edge {
        int u, v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public static int find(int[] ldr, int node) {
        if (ldr[node] != node) {
            ldr[node] = find(ldr, ldr[node]); // Path Compression
        }
        return ldr[node];
    }

    public static void join(int[] ldr, int u, int v) {
        int rootU = find(ldr, u);
        int rootV = find(ldr, v);

        if (rootU != rootV) {
            ldr[rootV] = rootU;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] ldr = new int[n + 1];
        int[] grpcnt = new int[n + 1];
        int[] ecnt = new int[n + 1];

        Edge[] edges = new Edge[m];

        // Initialize parent
        for (int i = 1; i <= n; i++) {
            ldr[i] = i;
        }

        // Read edges and union
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            edges[i] = new Edge(u, v);

            join(ldr, u, v);
        }

        // Count vertices in each connected component
        for (int node = 1; node <= n; node++) {
            int leader = find(ldr, node);
            grpcnt[leader]++;
        }

        // Count edges in each connected component
        for (Edge e : edges) {
            int leader = find(ldr, e.u);
            ecnt[leader]++;
        }

        long ans = 0;

        for (int node = 1; node <= n; node++) {
            long cnt = grpcnt[node];
            ans += (cnt * (cnt - 1)) / 2 - ecnt[node];
        }

        System.out.println(ans);
    }
}