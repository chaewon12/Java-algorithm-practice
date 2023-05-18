import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		List<Integer> arr =new ArrayList<>();
		while(N-->0){
			arr.add(Integer.parseInt(st.nextToken()));
		}
		int v = Integer.parseInt(br.readLine());
		System.out.println(Collections.frequency(arr,v));
	}
}