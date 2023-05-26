import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String str= br.readLine();
		String[] strArr = str.split("");

		String result= Arrays.stream(strArr)
			.sorted(Comparator.reverseOrder())
			.collect(Collectors.joining());

		System.out.println(result);
	}
}