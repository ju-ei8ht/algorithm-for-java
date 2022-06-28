import java.util.ArrayList;
import java.util.Arrays;

class Solution20_1 {
    public String solution(String[] participant, String[] completion) {
        ArrayList<String> arrCom = new ArrayList<>(Arrays.asList(completion));
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (String p : participant) { // for-each문 :int i = 0; i < participant.length; i++ (String p = participant[i])
            if (!arrCom.contains(p)) answer = p; // completion에 participant[i]가 포함되어 있지 않는 걸 return
            else arrCom.remove(p); //동명이인 remove
        }
        return answer;
    }
}

public class Test20_1 {
    public static void main(String[] args) {
        Solution20_1 sol = new Solution20_1();
        String result = sol.solution(new String[]{"mislav", "stanko", "mislav", "ana"},new String[]{"stanko", "ana", "mislav"});
        System.out.println(result);
    }
}
