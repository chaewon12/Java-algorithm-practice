import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] seq = new int[N];
		int[] memo = new int[N];
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++){
			seq[i]=Integer.parseInt(st.nextToken());
			memo[i]=1;
		}

		for(int i=0;i<N;i++){
			for(int j=0;j<i;j++){
				if(seq[j]<seq[i]){	// 증가 수열
					memo[i] = Math.max(memo[i],memo[j]+1);
				}
			}
		}
		int result = Arrays.stream(memo).max().getAsInt();
		System.out.println(result);
	}
}