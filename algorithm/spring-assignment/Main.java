class Bus1{
    final int busNumber;
    int speed;

    public Bus1(int busNumber) { //speed는 메소드 안에서만 값을 받을 것이라 bus객체 생성할 때는 제외
        this.busNumber = busNumber;
        this.speed = speed;
    }
    public void speed(int speed){ //이런 식으로 기능별 메소드 구현
        this.speed = speed;
        System.out.println("현재 속도가 "+speed+"입니다.");
        speed++;
        System.out.println("속도가 "+(speed-this.speed)+"만큼 변경되었습니다.");
    }
}
public class Main {
    public static void main(String[] args) {
        Bus1 bus = new Bus1(100); //클래스 객체 생성
        bus.speed(10); //메소드 실행
    }
}
