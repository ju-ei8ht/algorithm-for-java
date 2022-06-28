import javax.swing.*;
import java.util.Arrays;

class Solution17 {
    public boolean solution(String s) {
        boolean answer = true;
        String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
        String[] split = s.split("",s.length());
        String[] arr = new String[s.length()];
        int len = s.length();
        if(len == 4 || len == 6) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < numbers.length; j++) {
                    if (split[i].equals(numbers[j])) arr[i] = split[i];
                }
                if (arr[i] == null) answer = false;
            }
        }else answer = false;
        return answer;
    }
}

public class Test17 {
    public static void main(String[] args) {
        Solution17 sol = new Solution17();
        boolean result = sol.solution("1111a11111111");
        System.out.println(result);
    }
}
