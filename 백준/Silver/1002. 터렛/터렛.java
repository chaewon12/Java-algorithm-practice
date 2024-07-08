import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;

public class Main { 
	static int x1, y1, r1, x2, y2, r2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        while(N-- >0){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());	
            System.out.println(countPoint());
        }
    }

    static int countPoint(){
        // case 1 : 같은 중점이면서 반지름도 같은 경우 -> 무한
        if(x1==x2 && y1==y2 && r1==r2){
            return -1;
        }

        int distancePow = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // 두 점 사이의 거리의 제곱 

        // case 2-1: 두 반지름의 합이 두 점 사이의 거리보다 짧은 경우 (접하지 않음) -> 0개 
        if(distancePow > Math.pow(r1 + r2, 2)){
            return 0;
        }

        // case 2-2: 원 안에 원이 있지만 접하지 않음. distance < |r2-r1| -> 0개 
        if(distancePow < Math.pow(r2 - r1, 2)){
            return 0;
        }

        // case 3-1 : 한 점에서 내접할 때 
        if(distancePow == Math.pow(r2 - r1, 2)) {
            return 1;
        }

        // case 3-2 : 한 점에서 외접할 때 
        if(distancePow == Math.pow(r1 + r2, 2)) {
            return 1;
        }

        // 두 점에서 외접할 때
        else return 2; 
    }
}