import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // maxHeap -> minHeap 방향으로 저장된 숫자들이 커짐. maxHeap의 top에 위치한 값이 중간 값이 된다.
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            // 크기가 같은 경우 maxHeap에 입력된 값을 추가한다. 항상 maxHeap의 크기가 minHeap의 크기보다 크게 한다.
            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(number);
            } else {
                minHeap.add(number);
            }

            // minHeap의 최솟값보다 maxHeap의 최댓값보다 작다면 둘을 swap 한다.
            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int tmp = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(tmp);
                }
            }

            sb.append(maxHeap.peek());
            sb.append('\n');
        }

        System.out.println(sb);
    }
}