import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
    static int N;
    static int[][] abilities;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        abilities = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                abilities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        splitTeam(new boolean[N], 0);

        System.out.println(minDiff);
    }

    public static void splitTeam(boolean[] visited, int pIndex){
        if(pIndex == N){
            int diff = calcDiff(visited);
            minDiff = Math.min(minDiff, diff);

            return;
        }

        // 선택하는 경우
        visited[pIndex] = true;
        splitTeam(visited, pIndex+1);

        // 선택하지 않는 경우 
        visited[pIndex] = false;
        splitTeam(visited, pIndex+1);
    }

    public static int calcDiff(boolean[] visited){
        int startTeam = 0, linkTeam = 0;

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                // i, j	가 같은 팀일 때 능력치 계산 
                if(visited[i] == visited[j]){
                    if(visited[i]){
                        startTeam += abilities[i][j] + abilities[j][i];
                    } else{
                        linkTeam += abilities[i][j] + abilities[j][i];
                    }
                }
            }
        }

        return Math.abs(startTeam - linkTeam);
    }
}