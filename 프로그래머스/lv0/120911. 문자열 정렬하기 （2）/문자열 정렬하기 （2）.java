import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        char[] StringtoLowerChar = my_string.toLowerCase().toCharArray();
        Arrays.sort(StringtoLowerChar);
        
        String answer = new String(StringtoLowerChar);
        return answer;
    }
}