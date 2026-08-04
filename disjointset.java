import java.util.*;
public class Main{
	public static int find(int[] ldr,int n){
		if(ldr[n]!=n){
			ldr[n]=find(ldr, ldr[n]);
	
		return ldr[n];
	}
	public static void join(int[] ldr, int lt, int rt){
		int ldrlt=find(ldr,lt);
		int ldrrt=find(ldr,rt);
		ldr[ldrrt]=ldrlt;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int m = sc.nextInt();
		int[] ldr = new int[n+1];
		for(int i=1;i<=n;i++){ 
            ldr[i]=i;
        
        }
        for(int e=1;e<=m;e++){
        	int lt = sc.nextInt();
            int rt = sc.nextInt();
            join(ldr, lt, rt);

        }
        HashSet<Integer> set = new HashSet<>();
        for(int k=1; k<=n;k++){
            set.add(find(ldr,k));
        }
        System.out.println(set.size());
        
        
        

        
        
        
	}
}

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
        for(int j=1; j <=n;j++){
            ldr[j] = j;
        }
        for(int i=1; i<n;i++){
            int lt = sc.nextInt();
            int rt = sc.nextInt();
            join(ldr, lt, rt);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int k=1; k<=n;k++){
            set.add(find(ldr,k));
        }
        System.out.println(set.size());
    }
}*/