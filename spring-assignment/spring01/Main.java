public class Main {
    public static void main(String[] args) {
        Car bus = new Bus(1500,101);
        Car taxi = new Taxi(10000,4882,"서울");
        Car[] cars = {bus,taxi};
        for(Car car:cars){
            ((Driving) car).drive(30);
            System.out.println("------"); //기능별 구분용입니다.
            ((Riding) car).ride(20,10);
            System.out.println("------");
            ((Changing) car).speed(50,10);
            System.out.println("------");
            System.out.println("------");
        }
        ((Taxi) taxi).extraCharge(207);
        ((Taxi) taxi).pay();
    }
}
