import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String skills = br.readLine();
		int countL=0;
		int countS=0;
		int result=0;
		for(int i=0;i<N;i++){
			char c = skills.charAt(i);
			switch (c){
				case 'L' -> countL++;
				case 'S' -> countS++;
				case 'R' -> {
					if(countL==0){
						System.out.println(result);
						return;
					}
					countL--;
					result++;
				}
				case 'K'->{
					if(countS==0){
						System.out.println(result);
						return;
					}
					countS--;
					result++;
				}
				default -> result++;
			}
		}
		System.out.println(result);
	}
}