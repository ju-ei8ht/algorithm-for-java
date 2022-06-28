```java
import java.util.Arrays;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        if (answer == ""){
            answer = participant[participant.length-1];
        }
        return answer;
    }
}
```
[!문제 해설](algo20.png)
