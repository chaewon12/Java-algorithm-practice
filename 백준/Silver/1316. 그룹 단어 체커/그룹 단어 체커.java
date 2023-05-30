import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count = N;  

		for (int i = 0; i < N; i++) {
			boolean[] check = new boolean[26];

			String s = br.readLine();
			check[s.charAt(0) - 'a'] = true;
			for (int j = 1; j < s.length(); j++) {
				char c = s.charAt(j);

				if (c == s.charAt(j-1)) {
					continue;
				}
				
				if (check[c - 'a']) {
					count--;	// 그룹 단어 아님
					break;
				}
				
				check[c - 'a'] = true;  
			}
		}
		System.out.println(count);
	}
}