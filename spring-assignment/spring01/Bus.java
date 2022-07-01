public class Bus extends Car implements Driving,Riding,Changing {
    final int busNum;

    public Bus(int charge, int busNum) {
        super(charge);
        this.busNum = busNum;
    }

    public void end(){ //운행종료
        System.out.println(busNum+"번 버스의 운행이 종료됩니다.");
        if(this.nowPassenger != 0) System.out.println("승객 "+this.nowPassenger+"명이 하차하였습니다.");
    }

    @Override
    public void drive(int oil) { //운행시작
        this.oil = oil;
        if(oil < 10) System.out.println("운행을 시작하기에 주유량이 부족합니다.\n주유량은 최소 10 이상이 필요합니다.");
        state();
        if(oil >= 10){
            this.oil--;
            System.out.println("주유량이 1만큼 감소합니다.");
        }
    }

    public void state(){ //상태변경 - 상태변경은 수시로 일어나기 때문에 다른 메소드들 안에 추가했습니다.
        if(this.oil < 10){
            System.out.println("주유가 필요합니다.");
            this.state = false;
        }
        if(this.state) System.out.println(busNum+"번 버스는 현재 운행 중입니다.");
        else if(!this.state){
            if(this.nowPassenger > 0) end();
            System.out.println("차고지행으로 이동합니다.");
        }
    }

    @Override
    public void ride(int maxPassenger, int nowPassenger) { //승객탑승
        if(this.state){
            this.maxPassenger = maxPassenger;
            this.nowPassenger = nowPassenger;
            if(this.maxPassenger > this.nowPassenger){
                this.nowPassenger++;
                System.out.println("승객이 탑승하였습니다.");
            }else{
                System.out.print("현재 승객 수가 최대 승객 수");
                if(this.maxPassenger < this.nowPassenger){
                    System.out.println("를 초과하여 탑승하실 수 없습니다.");
                }
                if(this.maxPassenger == this.nowPassenger){
                    System.out.println("와 같아 만차입니다.\n더이상 탑승하실 수 없습니다.");
                }
            }
            this.oil--;
            System.out.println("주유량이 1만큼 감소합니다.");
            state();
        }
    }

    @Override
    public void speed(int nowSpeed, int changeSpeed) { //속도변경
        if(this.state){
            System.out.println("속도를 변경합니다.");
            System.out.print("주유량을 확인해주세요. ");
            System.out.println("현재 주유량: "+this.oil);
            if(this.oil < 10){
                System.out.println("주유량이 모자라 속도를 변경하지 못했습니다.");
                this.state = true;
            }else{
                this.nowSpeed = nowSpeed;
                System.out.print("현재 속도 "+this.nowSpeed);
                this.nowSpeed += changeSpeed;
                System.out.print("에서 속도를 ");
                if(changeSpeed > 0){
                    System.out.println("+"+changeSpeed+"만큼 변경했습니다.");
                    this.oil -= changeSpeed/2;
                    System.out.println("주유량이 "+changeSpeed/2+"만큼 감소합니다.");
                }else{
                    System.out.println(changeSpeed+"만큼 변경했습니다.");
                    this.oil--;
                    System.out.println("주유량이 1만큼 감소합니다.");
                }
            }
            this.state = false; //마지막까지 oil이 10 이상이면 강제 상태변경->운행종료
            state(); //마지막 상태변경
        }
    }
}
