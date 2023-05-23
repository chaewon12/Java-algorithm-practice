import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	static int recurCnt=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		fib(n);
		System.out.println(recurCnt+" "+(n-2));
	}

	static int fib(int x){
		if (x == 1 || x == 2){
			recurCnt++;
			return 1;
		}
		else{
			return (fib(x-1) + fib(x-2));
		}
	}
}