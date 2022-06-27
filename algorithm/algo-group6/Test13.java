import java.time.DayOfWeek;
import java.time.LocalDate;
//import java.time.format.TextStyle;
//import java.util.Locale;

//import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

class Solution13{
    public String solution(int a,int b){
        String answer = "";
        DayOfWeek date = LocalDate.of(2016,a,b).getDayOfWeek();
//        String dw = date.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        String subString = String.valueOf(date).substring(0,3);
        if(a < 13 && b < 32) answer = subString;
//            answer = toUpperCase(dw);
        return answer;
    }
}

public class Test13 {
    public static void main(String[] args) {
        Solution13 sol = new Solution13();
        String result = sol.solution(6,27);
        System.out.println(result);
    }
}