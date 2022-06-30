class Solution9{
    public String solution(String phone_number){
        String answer = "";
        int len = phone_number.length();
        String[] phoneSplit = phone_number.split("",len-3); //phone_number의 4자리만 남겨두고 자르기
        String star = "*";
        StringBuilder sb = new StringBuilder();
        if(len >= 4 && len <= 20){
            for(int i = 0; i < len-4; i++) sb.append(star); //phone_number 길이의 4개만 뺀 수로 star 채워둠
            answer = sb+""+phoneSplit[len-4]; //split으로 자른 마지막 그룹 phone_number 4자리 추가
        }
        return answer;
    }
}

public class Algorithm9 {
    public static void main(String[] args) {
        Solution9 sol = new Solution9();
        String result = sol.solution("027771889");
        System.out.println(result);
    }
}
