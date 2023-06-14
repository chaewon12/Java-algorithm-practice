import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if(N==K){
			System.out.println(0);
			return;
		}

		int[] visited = new int[100001];
		bfs(N,K,visited);
		System.out.println(visited[K]);
	}

	public static void bfs(int start,int end, int[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()){
			int curr=queue.remove();
			if(curr==end){
				return;
			}
			
			if(curr-1>=0 && visited[curr-1]==0){
				visited[curr-1]=visited[curr]+1;
				queue.add(curr-1);
			}

			if(curr+1<=100000 && visited[curr+1]==0){
				visited[curr+1]=visited[curr]+1;
				queue.add(curr+1);
			}

			if(curr*2<=100000 && visited[curr*2]==0){
				visited[curr*2]=visited[curr]+1;
				queue.add(curr*2);
			}
		}
	}
}