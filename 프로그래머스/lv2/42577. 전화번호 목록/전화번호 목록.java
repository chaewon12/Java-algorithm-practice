import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> phoneSet = new HashSet<String>(Arrays.asList(phone_book));
        
        for(String num :phone_book){
            for(int i=1; i<num.length();i++){
                if(phoneSet.contains(num.substring(0,i))){
                    return false;
                }
            }
        }
        
        return true;
    }
}