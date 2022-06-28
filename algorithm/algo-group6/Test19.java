class Solution19 {
    public String solution(int n) {
        String answer = "";
        for(int i = 0; i < n; i++){
            if(i % 2 == 0) answer += "수";
            else answer += "박";
        } return answer;
    }
}
public class Test19 {
    public static void main(String[] args) {
        Solution19 sol = new Solution19();
        String result = sol.solution(3);
        System.out.println(result);
    }
}
