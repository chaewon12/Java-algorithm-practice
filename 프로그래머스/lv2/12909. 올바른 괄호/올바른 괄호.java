import java.util.Stack; 

class Solution {  
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>(); 
        
        // 시작과 끝이 올바르지 않음
        if(s.charAt(0)==')'|| s.charAt(s.length()-1)=='(') return false;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(1);
            else{
                if(stack.empty()) return false; // 스택이 비어있으면 짝이 없는것임
                stack.pop();
            }       
        }
        
        // 모두 짝지어졌는지 확인
        if(stack.size()!=0) return false; 
        
        return true;
    }
}