import java.util.Arrays;

class Solution20 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int len = participant.length;
        String out = "";
        String same = "";
        if(len >= 1 && len <= 100000) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    out = participant[i];
                    if (participant[i].equals(participant[j])){
                        same = participant[i];//동명이인
                    }
                }
            }
            if (same == "") answer = out;
            else answer = same;
        }
        return answer;
    }
}
public class Test20 {
    public static void main(String[] args) {
        Solution20 sol = new Solution20();
                String result = sol.solution(new String[]{"leo", "kiki", "eden"},new String[]{"eden", "kiki"});
        System.out.println(result);
    }
}
