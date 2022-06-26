import java.util.Arrays;

class Solution3{
    public String solution(String s){
        String answer = "";
        String[] stringArray = s.split("", s.length());
        //받은 값을 split으로 s의 length만큼 쪼개고(음절)
        int num = s.length()/2;//s의 중간 찾기
        if(s.length() >= 1 && s.length() <= 100) {
            switch (s.length() % 2) {
                case 0:
                    answer = stringArray[num - 1] + "" + stringArray[num];
                    //짝수일 때 가운데 2문자를 가져와야 하니까 2로 나눴을 때
                    //나오는 문자와 바로 앞 문자를 같이 출력하면 되겠다고 생각
                    break;
                default:
                    answer = stringArray[num];
                    break;
            }
        }else answer = "길이가 1 이상, 10이하인 값을 입력해주세요.";

        return answer;
    }
}

public class Algorithm3 {
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        String result = sol.solution("qwer");
        System.out.println(result);
    }
}
//문제: 단어 s의 가운데 글자를 반환하는 함수 solution을 만들어 보세요.
//단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
//제한사항: s는 길이가 1 이상, 100이하인 스트링입니다.
