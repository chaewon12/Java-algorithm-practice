import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] Pi = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			Pi[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(Pi);

		int prev = 0;    // 이전 사람이 걸린 시간
		int total = 0;    // 모든 사람들의 시간 합
		for (int i = 0; i < N; i++) {
			prev += Pi[i];
			total += prev;
		}

		System.out.println(total);
	}
}