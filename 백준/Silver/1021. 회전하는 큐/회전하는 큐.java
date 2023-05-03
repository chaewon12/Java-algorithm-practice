import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> deque = new LinkedList<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= size; i++) {
			deque.offer(i);
		}

		int[] numbers = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int count = 0;
		for (int num : numbers) {
			int mid = (deque.size() - 1) / 2;
			int target_idx = deque.indexOf(num);

			if (target_idx <= mid) {
				// 2번 연산. target을 왼쪽으로 당김
				for (int i = 0; i < target_idx; i++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			} else {
				// 3번 연산. target을 오른쪽으로 당김
				for (int i = 0; i < deque.size() - target_idx; i++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			}
			deque.pollFirst();    // target 삭제
		}

		System.out.println(count);
	}
}