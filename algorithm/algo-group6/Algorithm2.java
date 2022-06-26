class Solution2{
    public String solution(int num){
        String answer = num % 2 == 0 ? "Even" : "Odd";
        return answer;
    }
}
public class Algorithm2 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        String result = sol.solution(0);
        System.out.println(result);
    }
}
//문제: 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수 solution을 완성해주세요.
//조건: num은 int 범위의 정수입니다. 0은 짝수입니다.