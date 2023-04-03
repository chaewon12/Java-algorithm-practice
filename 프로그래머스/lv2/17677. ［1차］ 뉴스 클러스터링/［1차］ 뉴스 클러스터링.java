import java.util.*;

class Solution {
    public static String match="^[a-zA-Z]*$"; 
    
    // 문자열 다중집합 추출 메소드
    public void getStrSet(String str, ArrayList<String> strList){    
        String temp="";
        for(int i=0; i<str.length()-1;i++){
            temp= str.substring(i,i+2);
            if(temp.matches(match))
                strList.add(temp);
        } 
    }
    
    // 자카드 유사도 메소드
    public double Jac(ArrayList<String> A, ArrayList<String> B){
        ArrayList<String> AsubB=(ArrayList<String>)A.clone();
        ArrayList<String> BsubA=(ArrayList<String>)B.clone();
        ArrayList<String> intersection=(ArrayList<String>)A.clone();
        ArrayList<String> union=new ArrayList<String>();
        
        if(A.size()==0 && B.size()==0)
            return 1.0;
        else{
             // A-B
            for(String s:B){   
                AsubB.remove(s);
            }
            
            // B-A
            for(String s:A){    
                BsubA.remove(s);
            }
            
            // 교집합
            for(String s:AsubB){  
                intersection.remove(s);
            }

            // 합집합
            union.addAll(AsubB);
            union.addAll(BsubA);
            union.addAll(intersection);
        }
        
        return (double)intersection.size()/union.size();
    }
    public int solution(String str1, String str2) {
        int answer = 65536;
        ArrayList<String> str1List=new ArrayList<String>(), str2List =new ArrayList<String>();
        
        getStrSet(str1.toUpperCase(), str1List);
        getStrSet(str2.toUpperCase(), str2List);
        
        answer*=Jac(str1List,str2List);
        
        return (int)(Math.floor(answer));
    }
}