class Solution6{
    public Object solution(int[] numbers){
       int len = numbers.length;
       String answer = "";
       int total = 45; //1~9를 array로 하고 값을 더할 수도 있지만...
       boolean isReduplicate = false;
        if(len >= 1 && len <= 9){
            for (int number : numbers) { //python의 row in rows처럼
                if (number >= 0 && number <= 9) total -= number;
                else return answer = "0~9까지만 입력할 수 있습니다.";
            }
            for(int j = 0; j < len; j++){
                for(int n = 0; n < j; n++){
                    if (numbers[j] == numbers[n]) {
                        isReduplicate = true;
                        //중복 체크
                        break;
                    }
                }
            }
            if(isReduplicate) return answer = "중복된 값이 있습니다.";
            else return total;
        }else return answer = "9개까지만 입력할 수 있습니다.";
    }
}

public class Algorithm6 {
    public static void main(String[] args) {
        Solution6 sol = new Solution6();
        int[] numbers = new int[] {1,2,3,4,6,7,8,0};
        Object result = sol.solution(numbers);
        System.out.println(result);
    }
}
//문제: 0~9까지 숫자 중 일부가 들어있는 정수 배경 numbers
//numbers에 없는 0~9 숫자를 모두 더한 값을 return
//제한사항: 1>=numbers의 길이<=9, 0>=numbers의 모든 원소<=9
//number의 모든 원소는 서로 다름