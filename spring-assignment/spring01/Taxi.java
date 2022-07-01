import java.text.DecimalFormat;

public class Taxi extends Car implements Driving,Riding,Changing{
    int taxiNum;
    String destination;
    int price;
    int distance;
    int extraCharge;

    public Taxi(int charge, int taxiNum, String destination) {
        super(charge);
        this.taxiNum = taxiNum;
        this.destination = destination;
        this.distance = 2;
        this.extraCharge = 100;
    }
    @Override
    public void drive(int oil) { //운행시작
        this.oil = oil;
        System.out.println(taxiNum+"번 택시의 현재 주유량은 "+this.oil+"입니다.");
        if(this.oil >= 10){
            System.out.println("택시의 운행을 시작합니다.");
        }else{
            System.out.println("주유량이 부족하여 운행을 시작할 수 없습니다.");
        }
    }

    @Override
    public void ride(int maxPassenger, int nowPassenger) { //승객탑승
        if(this.oil >= 10) {
            if (this.state) {
                this.nowPassenger = 1; //입력을 받은 값을 임의의 값(1)으로 고정(물론 nowPassenger로 받아도 상관없지만) -> 승객 탑승여부 확인
                System.out.println("승객이 탑승하였습니다.");
                this.state = false;
                System.out.println("택시의 상태가 일반에서 운행 중으로 변경되었습니다.");
            } else System.out.println("현재 택시는 운행 중입니다. 탑승이 불가합니다.");
        }
    }

    @Override
    public void speed(int nowSpeed, int changeSpeed) {
        if(this.oil >= 10) {
            System.out.println("속도를 변경합니다.");
            this.nowSpeed = nowSpeed;
            System.out.print("현재 속도 " + this.nowSpeed);
            this.nowSpeed += changeSpeed;
            System.out.print("에서 속도를 ");
            if (changeSpeed > 0) {
                System.out.println("+" + changeSpeed + "만큼 변경했습니다.");
            } else {
                System.out.println(changeSpeed + "만큼 변경했습니다.");
            }
        }
    }

    public void extraCharge(int finalDistance){
        this.price = price;
        if(this.nowPassenger == 1){
            if(finalDistance > distance){
                this.price = (distance * charge) + ((finalDistance - distance) * (charge + extraCharge));
                System.out.println("기본거리("+distance+"Km)보다 먼 곳은\n기본요금 "+charge+"원 외에 "+extraCharge+"원이 추가 거리만큼 할증이 붙습니다.");
            }else{
                this.price = finalDistance * charge;
            }
        }
    }

    public void pay(){
        if(this.nowPassenger == 1){
            DecimalFormat df = new DecimalFormat("###,###");
            System.out.println(taxiNum+"번 택시의 "+destination+"까지의 최종 요금은 "+df.format(this.price)+"원 입니다.");
        }
    }
}
