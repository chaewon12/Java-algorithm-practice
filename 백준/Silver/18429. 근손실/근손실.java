import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 백트래킹 문제
* 재귀적으로 문제를 해결하되 현재 재귀를 통해 확인 중인 상태가 제한 조건에 위배가 되는지 판단하고, 해당 상태가 위배되는 경우 해당 상태를 제외하고 다음 단계로 넘어간다.
* 백트래킹 특성에서 조건에 부합하지 않으면 이전 수행으로 돌아가야 함으로 BFS보다는 DFS이 구현하기 더 편하기 때문에 주로 DFS를 사용한다. 
*/
public class Main {
    static int N, K, count = 0;
    static int[] kits;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kits = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            kits[i] = Integer.parseInt(st.nextToken());
        }

        backTraking(500, 0);
        System.out.println(count);
    }

    static int calWeight(int weight, int kit){
        return weight + kit - K;
    }
		
    static void backTraking(int weight, int days){
        if(days == N){ // N일간 문제 조건을 항상 만족한 경우 카운트
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            if(visit[i] == false && calWeight(weight,kits[i]) >= 500) { // 문제 조건을 만족하는 노드일 때만 자식 노드로 탐색 이어나감 
                visit[i] = true;
                backTraking(calWeight(weight,kits[i]), days + 1);	//	 자식 노드 탐색 
                visit[i] = false; // 자식 노드 탐색 끝나면 방문 초기화. 다른 경우의 수 에서의 탐색을 위함
            }
        }
    }
}