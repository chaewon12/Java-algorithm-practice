import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N= Integer.parseInt(br.readLine());
		int[] arrN =new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++){
			arrN[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arrN);

		int M= Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<M;i++){
			System.out.println(binarySearch(arrN,Integer.parseInt(st.nextToken())));
		}
	}
	public static int binarySearch(int[] arr,int target){
		int l=0;
		int r=arr.length-1;

		while(l<=r){
			int mid=(l+r)/2;
			if(arr[mid]==target){
				return 1;
			}

			if(arr[mid]<target){
				l=mid+1;
			}else{
				r=mid-1;
			}
		}
		return 0;
	}
}