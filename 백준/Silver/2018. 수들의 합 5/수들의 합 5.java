import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int start=1;
		int end=1;
		int sum=1;
		int count=0;
		while(start<=end){
			if(sum==N){
				count++;
			}
			
			if(sum<N){
				end++;
				sum+=end;
			}else{
				sum-=start;
				start++;
			}
		}
		System.out.println(count);
	}
} 