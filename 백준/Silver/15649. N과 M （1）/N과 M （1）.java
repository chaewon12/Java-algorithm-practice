import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N+1];
        backtracking(new int[M], visited, 0);
    }

    static void backtracking(int[] sequence, boolean[] visited, int depth) {
        if(depth == M){
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                sequence[depth] = i; 
                visited[i] = true; 
                backtracking(sequence, visited, depth + 1); 
                visited[i] = false; 
            }
        }
    }
}
