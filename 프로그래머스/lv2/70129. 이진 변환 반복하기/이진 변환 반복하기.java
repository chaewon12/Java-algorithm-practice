class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt_conv=0;
        int cnt_zero=0;
        
        while(s!="1"){            
            int c=s.replace("0","").length();   // 1의 개수
            cnt_zero+=(s.length()-c);   // 0의 개수

            s = Integer.toBinaryString(c);  // c를 2진 문자열로 변환
            cnt_conv+=1;
            
            if(c==1) break; // Integer.toBinaryString(1)은 "01"을 반환함 
        }

        answer[0]=cnt_conv;
        answer[1]=cnt_zero;
        
        return answer;
    }
}