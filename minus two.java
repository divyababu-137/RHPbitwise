import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int odd=0,eoq=0,eeq=0;
		int curr=0;
		
		for(int i=0;i<n;i++){
			curr=sc.nextInt();
			if(curr%2==1){
				odd++;
			}
			else{
				int p=curr/2;
				if(p%2==1){
					eoq++;
				}
				else{
					eeq++;
				}
			}
			
		}
		System.out.print(Math.max(odd,Math.max(eoq,eeq)));
		
	}
}