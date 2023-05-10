import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count=0;
	static int vSize;
	static int eSize;
	static int[][] matrix;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		vSize=Integer.parseInt(br.readLine());
		eSize =Integer.parseInt(br.readLine());
		matrix = new int[vSize][vSize];
		visited =new boolean[vSize];

		while (eSize-->0){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;

			matrix[x][y]=1;
			matrix[y][x]=1;
		}

		find(0);

		System.out.println(count);
	}

	public static void find(int vertex){
		visited[vertex] = true;

		for(int i=0;i<vSize;i++){
			if(matrix[vertex][i]==1 && visited[i]==false){
				count++;
				find(i);
			}
		}
	}
}