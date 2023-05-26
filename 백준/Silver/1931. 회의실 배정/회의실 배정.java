import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Meet> meetings = new PriorityQueue<>((a,b)->{
			if(a.end==b.end) return a.start-b.start;
			return a.end-b.end;
		});

		while(N-->0){
			StringTokenizer st =new StringTokenizer(br.readLine());
			Meet m = new Meet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			meetings.add(m);
		}

		int count=1;
		int endTime=meetings.poll().end;	// 첫 강의
		while(!meetings.isEmpty()){
			Meet meet = meetings.poll();
			if(meet.start<endTime){
				continue;
			}
			count++;
			endTime=meet.end;
		}

		System.out.println(count);
	}
	static class Meet{
		public int start;
		public int end;

		public Meet(int start,int end){
			this.start=start;
			this.end=end;
		}
	}
}