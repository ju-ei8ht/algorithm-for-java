//import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

class Solution16 {
    boolean solution(String s) {
        boolean answer = true;
//        s = toUpperCase(s);
        String[] split = s.split("",s.length());
        int p = 0;
        int y = 0;
        for(int i = 0; i < s.length(); i++){
//            if(split[i].equals("P") || split[i].equals("p")) p += 1;
//            if(split[i].equals("Y") || split[i].equals("y")) y += 1;
            switch (split[i]) {
                case "P":
                case "p":
                    p += 1;
                    break;
                case "Y":
                case "y":
                    y += 1;
                    break;
            }
        }
        if(p != y) answer = false;
        return answer;
    }
}
public class Test16 {
    public static void main(String[] args) {
        Solution16 sol = new Solution16();
        boolean result = sol.solution("pPoooyY");
        System.out.println(result);
    }
}
