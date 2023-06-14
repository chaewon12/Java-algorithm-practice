import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    private static int M;
    private static int N;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] visited = new int[N][M];
        Queue<Point> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int state = Integer.parseInt(st.nextToken());
                visited[i][j] = state;
                if(state==1){
                    queue.add(new Point(i,j));
                }
            }
        }
        
        // 처음부터 모두 익음
        if(queue.size()==M*N){
            System.out.println(0);
            return;
        }

        Point end=bfs(visited,queue);

        boolean containsZero=Arrays.stream(visited)
                .flatMapToInt(Arrays::stream)
                .anyMatch(t -> t == 0);

        System.out.println(containsZero?-1:visited[end.x][end.y]-1);
    }

    private static Point bfs(int[][] visited, Queue<Point> queue) {
        Point curr=null;
        while (!queue.isEmpty()){
            curr=queue.remove();

            for(int i=0;i<4;i++){
                int nx = curr.x+dx[i];
                int ny = curr.y+dy[i];

                if(0<=nx && nx<N && 0<=ny && ny<M
                        && visited[nx][ny]==0){
                    visited[nx][ny]=visited[curr.x][curr.y]+1;
                    queue.add(new Point(nx,ny));
                }
            }
        }
        return curr;
    }
}
