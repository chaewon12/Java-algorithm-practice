import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
	static int[][] dir={
		{-1,0},{1,0},{0,-1},{0,1}
	};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] area = new int[N][N];
		int maxHeight=0;
		for(int i=0; i<N;i++){
			StringTokenizer st =new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N;j++){
				int v = Integer.parseInt(st.nextToken());
				area[i][j]= v;
				maxHeight=Math.max(maxHeight,v);
			}
		}

		int maxCount=1;
		for(int rain=1;rain<maxHeight;rain++){
			boolean[][] visited =new boolean[N][N];
			int count=0;

			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(area[i][j]>rain && !visited[i][j]){
						count+=1;
						bfs(rain, area, visited,i,j);
					}
				}
			}

			maxCount=Math.max(maxCount,count);
		}
		System.out.println(maxCount);

	}

	public static void bfs(int rain, int[][] area, boolean[][] visited,int x, int y){
		visited[x][y]=true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});

		while(!queue.isEmpty()){
			int[] v = queue.poll();

			for(int i=0;i<dir.length;i++){
				int nX=v[0]+dir[i][0];
				int nY=v[1]+dir[i][1];

				if(nX>=0 && nY>=0 && nX<area.length && nY<area.length	// 지도 상에 존재할 수 있는 좌표인지
					&& area[nX][nY]> rain && !visited[nX][nY]){ // 안전하고 방문 전 인지
					queue.add(new int[] {nX,nY});
					visited[nX][nY]=true;
				}
			}
		}
	}
}