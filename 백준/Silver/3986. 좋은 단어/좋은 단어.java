import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int result=0;
		while(N-->0){
			String word = br.readLine();

			if(word.length()%2==1){
				continue;
			}

			Stack<Character> stack = new Stack<>();
			stack.push(word.charAt(0));
			for(int i = 1; i < word.length(); i++){
				char c = word.charAt(i);

				if(!stack.isEmpty() && stack.peek() == c){
					stack.pop();
				}else{
					stack.push(c);
				}
			}

			if(stack.isEmpty()){
				result++;
			}
		}

		System.out.println(result);
	}
}