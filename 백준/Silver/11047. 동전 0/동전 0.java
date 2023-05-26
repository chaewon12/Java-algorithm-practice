import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];
		for(int i=N-1;0<=i;i--){
			coins[i]=Integer.parseInt(br.readLine());
		}

		int count=0;
		for(int i=0;i<N;i++){
			if(K==0){
				break;
			}

			int coin=coins[i];
			
			if(K<coin){
				continue;
			}
			
			count+=K/coin;
			K%=coin;
		}
		System.out.println(count);
	}
}