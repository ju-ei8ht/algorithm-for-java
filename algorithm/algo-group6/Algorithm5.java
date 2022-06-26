class Solution5{
    public Object solution(String s){
        Object answer;
        int len = s.length();
        int first = Integer.parseInt(s.split("",len)[0]);
        if (len >= 1 && len <= 5) {
            if(first != 0) try {
                answer = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                answer = "잘못된 값을 입력하셨습니다. 숫자만 입력해주세요.";
                //입력값에 string이 포함되었을 경우
                //parseInt가 안 되므로
            }
            else answer = "0으로 시작할 수 없습니다.";
            //parseInt를 하면 0으로 시작해도 결과값에 0부터 시작하지 않는다는 건 알지만
            //제한조건에 's'는(입력값) 0으로 시작하지 않는다고 하니까 ㅎㅎ;
        } else answer = "1 이상 5 이하의 길이로 입력해주세요.";
        return answer;
    }
}
public class Algorithm5 {
    public static void main(String[] args) {
        Solution5 sol = new Solution5();
        Object result = sol.solution("123");
        System.out.println(result);
    }
}
//문제: 문자열 s를 숫자로 변환한 결과 반한
//제한 조건: s의 길이는 1 이상 5 이하
//s는 부호와 숫자로만 이루어져있습니다.
//s는 0으로 시작하지 않습니다.