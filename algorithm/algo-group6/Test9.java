class Solution9{
    public String solution(String phone_number){
        String answer = "";
        int len = phone_number.length();
        String[] phoneSplit = phone_number.split("",len-1);
        String star = "*";
        StringBuilder sb = new StringBuilder();
        if(len >= 4 && len <= 20){
            for(int i = 0; i < len-4; i++){
                sb.append(star);
            }
            System.out.println(sb+""+phoneSplit[len-4]+""+phoneSplit[len-3]+""+phoneSplit[len-2]);
        }
        return answer;
    }
}

public class Test9 {
    public static void main(String[] args) {
        Solution9 sol = new Solution9();
        String result = sol.solution("027778888");
        System.out.println(result);
    }
}
