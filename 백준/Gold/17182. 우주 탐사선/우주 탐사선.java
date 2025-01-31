import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
    static int N, K;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

        floydWarshall();
        
        visited[K] = true;
        dfs(K, 0, 1);

        System.out.println(answer);
    }

    // 플로이드-워셜 알고리즘으로 모든 노드에서의 모든 노드 까지의 최소 시간 계산
    static void floydWarshall(){
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(i==j) continue;
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }
    }

    // dfs로 최단거리 탐색
    static void dfs(int start, int sum, int depth){
        if(depth == N){
            answer = Math.min(answer,sum);
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, sum+graph[start][i], depth+1);
                visited[i] = false;
            }
        }
    }
}
