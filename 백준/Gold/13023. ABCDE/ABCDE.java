import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	static boolean found = false;

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());

		List<List<Integer>> graph =new ArrayList<>();
		for(int i=0; i<N;i++){
			graph.add(i,new ArrayList<>());
		}

		for(int i=0; i<M;i++){
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		boolean[] visited = new boolean[N];
		for(int i=0;i<N;i++){
			dfs(graph,visited,i,1);
			if(found){
				System.out.println("1");
				return;
			}
		}

		System.out.println("0");
	}

	static void dfs(List<List<Integer>> graph,boolean[] visited,int v,int depth){
		if(depth == 5){
			found=true;
			return;
		}

		visited[v]=true;
		for(int vertex:graph.get(v)){
			if(!visited[vertex]){
				dfs(graph,visited,vertex,depth+1);
			}
		}

		visited[v]=false; // 한 번의 탐색이 끝나면 visited 초기화
	}
}