public class Parent extends Human implements Walkable, Runable{
    public Parent(String name, int age) {
        super(name, age, 3);
    }
    public void run(int x, int y){
        printWhoAmI();
        System.out.println("run speed: " + speed+2);
        this.x = x;
        this.y = y;
        System.out.println("ran to " + getLocation());
    }
    public void walk(int x, int y){
        printWhoAmI();
        System.out.println("walk speed: " + speed);
        this.x = x;
        this.y = y;
        System.out.println("walked to " + getLocation());
    }
}
