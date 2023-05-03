import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException{
		Deque<Integer> deque= new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());

		while(count > 0) {
			count--;
			String[] cmd = br.readLine().split(" ");

			switch (cmd[0]) {
				case "push_front":
					deque.offerFirst(Integer.parseInt(cmd[1]));
					break;
				case "push_back":
					deque.offerLast(Integer.parseInt(cmd[1]));
					break;
				case "pop_front":
					System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
					break;
				case "pop_back":
					System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
					break;
				case "size":
					System.out.println(deque.size());
					break;
				case "empty":
					System.out.println(deque.isEmpty() ? 1 : 0);
					break;
				case "front":
					System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
					break;
				case "back":
					System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
					break;
				default:
					throw new IllegalStateException("Unexpected value: " + cmd[0]);
			}
		}
	}
}