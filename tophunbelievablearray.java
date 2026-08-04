import java.util.*;
public class Main{
	static final int MAX_VAL = 100005;
	public static int find(int[] ldr,int n){
		if(ldr[n]!=n){
			ldr[n]=find(ldr, ldr[n]);
		}
	
		return ldr[n];
	}
	public static void join(int[] ldr, int lt, int rt){
		int ldrlt=find(ldr,lt);
		int ldrrt=find(ldr,rt);
		ldr[ldrrt]=ldrlt;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		if (!sc.hasNextInt()) return;
        int T = sc.nextInt(); 
        for (int t = 1; t <= T; t++) {
            System.out.println("Case " + t + ":");
		    int n = sc.nextInt();
		    int q = sc.nextInt();
		    int[] arr = new int[n+1];
		    for(int i=1;i<=n;i++){
		    	arr[i]=sc.nextInt();
		    }
		    int[] ldr = new int[MAX_VAL];   
            int[] val = new int[MAX_VAL];   
            int[] map = new int[MAX_VAL];   
            
            
            for (int i = 1; i < MAX_VAL; i++) {
            	ldr[i] = i;
                val[i] = i;
                map[i] = i;
            }
		
		    while(q-- >0){
		    		int lt = sc.nextInt();
		    		if(lt==1){
				    int x = sc.nextInt();
				    int y = sc.nextInt();
				    if(x==y) continue;
				    int rootx = find(ldr, map[x]);
				    int rooty = find(ldr, map[y]);
				    if(val[rootx]!=x) continue;
				    if(val[rooty] == y){
				    	ldr[rootx]=rooty;
				    }
				    else{
				    	val[rootx] = y;
					    map[y] = rootx;
				    }
				    map[x]=0;
			       }
			       else{
			       	int idx = sc.nextInt();
				    int originalvalue = arr[idx];
				    int currentroot = find(ldr, originalvalue);
				    System.out.println(val[currentroot]);
			      }
		 }
	}
	
}}