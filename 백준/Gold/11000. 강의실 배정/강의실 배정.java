import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<int[]> lessones =new ArrayList<>();
		while(N-->0){
			StringTokenizer st =new StringTokenizer(br.readLine()," ");
			lessones.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});

		}

		Collections.sort(lessones,(a,b)->{return a[0]==b[0] ? a[1]-b[1] : a[0]-b[0];});

		PriorityQueue<Integer> rooms = new PriorityQueue<>();
		rooms.add(lessones.get(0)[1]);	// 종료 시간 저장

		for(int i=1;i<lessones.size();i++){
			int[] lesson = lessones.get(i);
			if(rooms.peek()<=lesson[0]){	// 강의실 이어서 사용(이전 강의 뺌)
				rooms.poll();
			}
			rooms.add(lesson[1]);
		}

		System.out.println(rooms.size());
	}
}