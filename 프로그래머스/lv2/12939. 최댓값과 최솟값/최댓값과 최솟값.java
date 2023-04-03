import java.util.*;

class Solution {
    public String solution(String s) {
        String[] splits = s.split(" ");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<splits.length; i++) {
          arr.add(Integer.parseInt(splits[i]));
        }
        
        return Collections.min(arr) + " " + Collections.max(arr);          
    }
}