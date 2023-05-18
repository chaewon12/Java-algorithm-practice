import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pay = Integer.parseInt(br.readLine());

		int[] money = {500,100,50,10,5,1};
		int total=1000-pay;
		int result=0;

		for(int m: money){
			if(total<m){
				continue;
			}
			result+=total/m;
			total%=m;
		}

		System.out.println(result);
	};
}