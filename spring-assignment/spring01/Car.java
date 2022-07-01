public class Car {
    int oil;
    int nowSpeed;
    int changeSpeed;
    int charge;
    int maxPassenger;
    int nowPassenger;
    boolean state;

    public Car(int oil, int nowSpeed, int maxPassenger, int changeSpeed, int charge, int nowPassenger, boolean state) {
        this.oil = oil;
        this.nowSpeed = nowSpeed;
        this.changeSpeed = changeSpeed;
        this.charge = charge;
        this.maxPassenger = maxPassenger;
        this.nowPassenger = nowPassenger;
        this.state = state;
    }

    public Car(int charge) {
        this(0,0,0,0,charge,0,true);
    }
}
