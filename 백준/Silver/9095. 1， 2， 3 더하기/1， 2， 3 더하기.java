import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[11];
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		while(T-->0){
			int n = Integer.parseInt(br.readLine());
			for(int i=4;i<=n;i++){
				dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
			}
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}
} 