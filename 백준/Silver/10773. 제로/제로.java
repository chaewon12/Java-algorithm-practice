import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack =new Stack<>();
		while(N-->0){
			int num = Integer.parseInt(br.readLine());
			if(num==0){
				stack.pop();
				continue;
			}
			stack.push(num);
		}
		
		int sum=0;
		while (!stack.isEmpty()) {
            sum += stack.pop();
        }
		
		System.out.println(sum);
	}
} 