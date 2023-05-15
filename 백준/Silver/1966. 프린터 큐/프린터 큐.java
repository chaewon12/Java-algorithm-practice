import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCnt = Integer.parseInt(br.readLine());

		LinkedList<int[]> queue = new LinkedList<>();
		while (testCnt-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// 문서의 개수
			int M = Integer.parseInt(st.nextToken());	// 타겟 위치

			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++){
				queue.offer(new int[] { i, Integer.parseInt(st.nextToken()) });	//위치, 중요도
			}

			int count=0;
			while (!queue.isEmpty()){
				int[] front = queue.poll();
				boolean flag = true;

				for(int i = 0; i < queue.size(); i++) {
					// 맨 앞보다 i가 중요도 높음 -> 맨 앞 ~ i-1를 뒤로 이동
					if(front[1]<queue.get(i)[1]){
						queue.offer(front);
						for(int j = 0; j < i; j++) {
							queue.offer(queue.poll());
						}
						flag = false;	// 이동을 수행했다면 front는 1순위가 아님
						break;
					}
				}

				// 이동 수행이 한 번도 없었다면 이 시점에서 front가 중요도 1순위
				if(flag == true) {
					count++;
					if(front[0]==M){
						break;
					}
				}
			}
			sb.append(count).append('\n');
			queue.clear();
		}
		System.out.println(sb);
	}
}