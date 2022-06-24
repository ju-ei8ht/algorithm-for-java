import java.util.Scanner;

public class Algorithm1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String star = "*";
        StringBuilder sb = new StringBuilder();
        if(n <= 1000 && m <= 1000 && n!=m) {
            for (int i = 0; i < n; i++) {
                sb.append(star);
            }
            for (int i = 0; i < m; i++) {
                System.out.println(sb);
            }
        }else if(n==m){
            System.out.println("가로와 세로 길이가 달라야 합니다.");
        }else{
            System.out.println("1000이하인 자연수를 입력해주세요.");
        }
    }
}
