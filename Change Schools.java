import java.util.*;
class Main{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int arr[]=new int[k+1];
		for(int i=1;i<=n;i++){
			int c=sc.nextInt();
			arr[c]++;
			
			
		}
		int max=0;
		for(int i=1;i<=k;i++){
			max=Math.max(arr[i],max);
		}
		int join=0;
		for(int j=1;j<=k;j++){
			if(arr[j]>=max-1){
				join++;
			}
		}
		System.out.println(join);
	}
}