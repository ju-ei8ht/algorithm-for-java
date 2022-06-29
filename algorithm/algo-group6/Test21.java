import java.util.Arrays;

class Solution21 {
    public String solution(String s) {
        String answer = "";
//        for(int i = 0; i < s.length(); i++){
//            if(i % 2 == 0){
//                if(s.charAt(i) > 96) answer += (char)(s.charAt(i)-32); //소문자면 대문자로
//                else if(s.charAt(i) > 64 || s.charAt(i) == 32) answer += (char)s.charAt(i); //대문자/공백은 그대로
//            }
//            else{
//                if(s.charAt(i) > 96 || s.charAt(i) == 32) answer += (char)s.charAt(i);//소문자/공백은 그대로
//                else if(s.charAt(i) > 64) answer += (char)(s.charAt(i)+32); //대문자면 소문자로
//            }
//        }
        String[] split = s.split(" ",s.length());
        for(int i = 0; i < split.length; i++){
            for(int j = 0; j < split[i].length(); j++){
                if(j % 2 == 0){
                    if(split[i].charAt(j) > 96) answer += (char)(split[i].charAt(j)-32); //소문자면 대문자로
                    else if(split[i].charAt(j) > 64 || split[i].charAt(j) == 32) answer += (char)split[i].charAt(j); //대문자/공백은 그대로
                }
                else{
                    if(split[i].charAt(j) > 96 || split[i].charAt(j) == 32) answer += (char)split[i].charAt(j);//소문자/공백은 그대로
                    else if(split[i].charAt(j) > 64) answer += (char)(split[i].charAt(j)+32); //대문자면 소문자로
                }
            }
            if(i != split.length-1) answer += " ";
        }
        return answer;
    }
}
public class Test21 {
    public static void main(String[] args) {
        Solution21 sol = new Solution21();
        String result = sol.solution("try hello world");
        System.out.println(result);
    }
}
