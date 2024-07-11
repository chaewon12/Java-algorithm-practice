import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int round = 0; // 라운드 수가 짝수면 창영이가, 홀수면 상근이가 승리이다.
        while(N>0){
            if(N < 3 || N % 2 == 0){
                N -= 1;
            } else{
                N -= 3;
            }
            round++;
        }

        System.out.println((round % 2 == 0) ? "CY" : "SK");
    }
}