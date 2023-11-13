import java.util.*;
class Work {
    String name;
    int start;
    int playTime;

    public Work(String name, String start, String playTime) {
        this.name = name;
        this.start = ConvertToInt(start);
        this.playTime = Integer.parseInt(playTime);
    }

    public int ConvertToInt(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);

        return hour * 60 + min;
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        PriorityQueue<Work> todo = new PriorityQueue<Work>((o1,o2)->o1.start-o2.start);
        Stack<Work> stop = new Stack<Work>();
        for(String[] work : plans){
            todo.add(new Work(work[0],work[1],work[2]));
        }
 
        int idx = 0;
        int nowTime = 0;
        while(!todo.isEmpty()){
            Work nowWork = todo.poll();
            
            if (todo.isEmpty()) {                
                answer[idx++] = nowWork.name;                 
                continue;            
            }
           
            Work nextWork = todo.peek();
            
            if(nextWork.start < nowWork.start + nowWork.playTime){
                nowWork.playTime -= nextWork.start - nowTime;
                stop.push(nowWork);
                
                nowTime = nextWork.start;
            }else if (nextWork.start == nowWork.start + nowWork.playTime) {                
                answer[idx++] = nowWork.name;                
                nowTime = nextWork.start;                                                      
            }else{
                answer[idx++] = nowWork.name;   
                
                if(stop.isEmpty()){
                    nowTime = nextWork.start;
                    continue;
                }
                
                nowTime = nowWork.start + nowWork.playTime;
                while(!stop.isEmpty()){
                    Work stopWork = stop.pop();
                    
                    if(nextWork.start < nowTime + stopWork.playTime){
                        stopWork.playTime -= nextWork.start - nowTime;
                        stop.push(stopWork);
                
                        nowTime = nextWork.start;
                        
                        break;
                    }else if(nextWork.start == nowTime + stopWork.playTime){
                        answer[idx++] = stopWork.name;                
                        nowTime = nextWork.start;   
                        break;
                    }else{
                        answer[idx++] = stopWork.name;   
                        nowTime += stopWork.playTime;
                    }
                }               
            }
        }
        
        while(!stop.isEmpty()) {            
            answer[idx++] = stop.pop().name;        
        }

        return answer;
    }  
}
