import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();
		int[] dp =new int[M];

		int count=0;
		for(int i=1; i<M-1;i++){
			if(S[i]=='O' && S[i+1]=='I'){
				dp[i+1]=dp[i-1]+1;	// 'I' 인덱스에 쌍의 수 저장

				if(dp[i+1]>=N && S[i-2*N+1]=='I'){	// OI N개의 쌍 앞에 I가 있는지 
					count++;
				}
			}
		}

		System.out.println(count);
	}
}