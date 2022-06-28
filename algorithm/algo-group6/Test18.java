class Solution18 {
    public String solution(String[] seoul) {
        String answer = "김서방은 없다";
        if(seoul.length >= 1 && seoul.length <= 1000) {
            for (int i = 0; i < seoul.length; i++) {
                if (seoul[i].equals("Kim")) answer = "김서방은 " + i + "에 있다";
            }
        }else answer = "1개 이상 1000개 이하로 값을 넣어주세요.";
        return answer;
    }
}
public class Test18 {
    public static void main(String[] args) {
        Solution18 sol = new Solution18();
        String result = sol.solution(new String[]{"Jane"});
        System.out.println(result);
    }
}