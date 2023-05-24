import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> unheard = new HashSet<>();
		while(N-->0){
			unheard.add(br.readLine());
		}

		SortedSet<String> result = new TreeSet<>();
		while(M-->0){
			String name = br.readLine();
			if(unheard.contains(name)){
				result.add(name);
			}
		}

		StringBuilder sb =new StringBuilder();
		sb.append(result.size()).append("\n");
		result.forEach(n->sb.append(n).append("\n"));
		System.out.println(sb);
	}
}
