import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());

		st=new StringTokenizer(br.readLine()," ");
		int[] nums =new int[N];
		for(int i=0; i<N;i++){
			nums[i]=Integer.parseInt(st.nextToken());
		}

		int maxSum=0;
		for(int i=0; i<N-2;i++){
			for(int j=i+1; j<N-1;j++){
				for(int k=j+1; k<N;k++){
					int temp = nums[i] + nums[j] + nums[k];
					if(temp==M){
						System.out.println(temp);
						return;
					}

					if(maxSum < temp && temp < M) {
						maxSum = temp;
					}
				}
			}
		}

		System.out.println(maxSum);
	}
}