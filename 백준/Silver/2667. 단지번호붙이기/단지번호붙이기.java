import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main{
	static int size=0;	// 단지의 크기
	static int[][] direction={
		// { 좌 우 상 하 } 이동 좌표
		{-1,0}, {1,0}, {0,-1},{0,1}
	};

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());

		int[][] map =new int[N][N];
		boolean[][] visited=new boolean[N][N];

		for(int i=0; i<N;i++){
			String line=br.readLine();
			for(int j=0; j<N;j++){
				map[i][j]=line.charAt(j)-'0';
			}
		}

		List<Integer> result =  new ArrayList<>();
		for(int i=0; i<N;i++){
			for(int j=0; j<N;j++){
				if(map[i][j]==1 && !visited[i][j]){
					size=1;
					dfs(N, map,visited,i,j);
					result.add(size);
				}
			}
		}

		Collections.sort(result);

		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		result.forEach(i->sb.append(i).append("\n"));
		System.out.println(sb);
	}

	public static void dfs(int N, int[][] map, boolean[][] visited,int x,int y){
		visited[x][y]=true;

		for(int i=0;i<direction.length;i++){
			int nX=x+direction[i][0];
			int nY=y+direction[i][1];

			if(nX>=0 && nY>=0 && nX<N && nY<N 	// 지도 상에 존재할 수 있는 좌표인지
				&& map[nX][nY]==1 && !visited[nX][nY]){ // 집이 있고 방문 전 인지
				size+=1;
				dfs(N, map,visited,nX,nY);
			}
		}
	}
}