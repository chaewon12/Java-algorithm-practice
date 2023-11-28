import java.util.*;

class Solution {
    static int size;
    static String[] numArray;
    static boolean[] visited;
    static Set<Integer> primeSet = new HashSet<>();
    
    public int solution(String numbers) {
        size = numbers.length();
        numArray = numbers.split("");
        visited = new boolean[size];
        
        updatePrimeSet("");
        return primeSet.size();
    }
    
    private void updatePrimeSet(String numStr) {
        if (!numStr.isEmpty()) {
            if(isPrime(Integer.parseInt(numStr))){
                primeSet.add(Integer.parseInt(numStr));
            }            
        }

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                updatePrimeSet(numStr + numArray[i]);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; 
            }
        }
        
        return true;
    }
}