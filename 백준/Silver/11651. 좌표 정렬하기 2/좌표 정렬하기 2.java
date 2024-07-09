import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Main { 
    static class Point {
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String toString(){ 
            return x+" "+y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());

        List<Point> points = new ArrayList<>();
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x,y));
        }

        Collections.sort(points, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                if(p1.y > p2.y){
                    return 1;
                } else if(p1.y < p2.y){
                    return -1;
                } else{
                    return Integer.compare(p1.x, p2.x);
                }
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(Point p : points){
            sb.append(p.toString());
            sb.append('\n');
        }
        System.out.println(sb);
    }
}