import java.util.Scanner;

class Solution4{
    public long solution(int a, int b){
        long answer = 0;
        if(a <= b) while (a <= b) {//i=(a-1);i<b;i++
            answer += a;//i+1
            a++;
        }
        else while (b <= a) {
            answer += b;
            b++;
        }//a와 b의 대소관계는 정해져있지 않으므 반대의 경우도 추가
        return answer;
    }
}
public class Algorithm4 {
    public static void main(String[] args) {
        Solution4 sol = new Solution4();
        long result = sol.solution(3,5);
        System.out.println(result);
    }
}
//문제: a와 b 사이에 속한 모든 정수의 합을 리턴
//a=3, b=5인 경우, 3+4+5=12를 리턴
//제한 조건: a와 b가 같은 경우 둘 중 아무 수나 리턴
//a와 b의 대소관계는 정해져있지 않다.
