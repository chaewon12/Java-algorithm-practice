import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if(N==1){
			System.out.println(br.readLine());
			return;
		}
		
		int[] stair = new int[N + 1];
		int[] score = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		// find
		score[1] = stair[1];
		score[2] = stair[1] + stair[2];
		for (int i = 3; i <= N; i++) {
			score[i] = Math.max(score[i - 3] + stair[i - 1], score[i - 2]) + stair[i];
		}

		System.out.println(score[N]);
	}
}