import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String endStr = "666";
		int currNum=665;
		int count=0;
		while (count != N){
			currNum++;

			if (String.valueOf(currNum).contains(endStr)){
				count++;
			}
		}

		System.out.println(currNum);
	}
}