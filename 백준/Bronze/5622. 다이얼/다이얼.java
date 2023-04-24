import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Map<Character, Integer> dialMap = new HashMap<>() {{
            put('A', 2);
            put('B', 2);
            put('C', 2);
            put('D', 3);
            put('E', 3);
            put('F', 3);
            put('G', 4);
            put('H', 4);
            put('I', 4);
            put('J', 5);
            put('K', 5);
            put('L', 5);
            put('M', 6);
            put('N', 6);
            put('O', 6);
            put('P', 7);
            put('Q', 7);
            put('R', 7);
            put('S', 7);
            put('T', 8);
            put('U', 8);
            put('V', 8);
            put('W', 9);
            put('X', 9);
            put('Y', 9);
            put('Z', 9);
        }};
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int total=0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            total+=dialMap.get(c)+1;
        }
        
        System.out.println(total);
    }
}