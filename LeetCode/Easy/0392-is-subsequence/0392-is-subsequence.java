class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        
        if (s.length() > t.length()) {
            return false; 
        }
        
        int sIndex = 0;
        for(int tIndex = 0; tIndex < t.length(); tIndex++){
            if (s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
                
                if (sIndex == s.length()) {
                    return true; 
                }
            }
        }
        return false; 
    }
}