import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size=Integer.parseInt(br.readLine());
		int[] numbers = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		int target=Integer.parseInt(br.readLine());

		int count = 0;
		int start = 0;
		int end = size - 1;

		while(start < end) {
			int sum = numbers[start] + numbers[end];

			if(sum < target) {	// 작으면 start 이동 시켜서 sum 커지게
				start++;
				continue;
			}
			if(sum > target) { // 크면 end 이동 시켜서 sum 작아지게
				end--;
				continue;
			}
			start++;
			end--;
			count++;
		}
		
		System.out.println(count);
	}
}