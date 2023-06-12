import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		HashSet<String> waitingSet = new LinkedHashSet<>();
		for(int i=0;i<L;i++){
			String studentNumber = br.readLine();
			if(waitingSet.contains(studentNumber)){
				waitingSet.remove(studentNumber);
			}
			waitingSet.add(studentNumber);
		}

		StringBuilder sb = new StringBuilder();
		for(String studentNum : waitingSet){
			K--;
			sb.append(studentNum).append("\n");
			if(K==0){
				break;
			}
		}

		System.out.println(sb);
	}
}