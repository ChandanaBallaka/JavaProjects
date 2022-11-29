package factorydesign4;

enum CarType {
    SMALL,
    SEDAN,
    LUXURY
}
abstract class Car {

    private CarType model;

    public Car(CarType model) {
        this.model = model;
    }

    protected abstract void construct();

    public CarType getModel() {
        return model;
    }

    public void setModel(CarType model) {
        this.model = model;
    }
}
class LuxuryCar extends Car{
    public LuxuryCar(CarType model) {
        super(model);
    }

    @Override
    protected void construct() {
        System.out.println("Constructing Luxury Car");
    }

    @Override
    public CarType getModel() {
        return super.getModel();
    }

    @Override
    public void setModel(CarType model) {
        super.setModel(model);
    }
}
class SmallCar extends Car{
    public SmallCar(CarType model) {
        super(model);
    }

    @Override
    protected void construct() {
        System.out.println("Constructing Small Car");
    }

    @Override
    public CarType getModel() {
        return super.getModel();
    }

    @Override
    public void setModel(CarType model) {
        super.setModel(model);
    }
}
class SedanCar extends Car{

    public SedanCar(CarType model) {
        super(model);
    }

    @Override
    protected void construct() {
        System.out.println("Constructing Sedan Car");
    }

    @Override
    public CarType getModel() {
        return super.getModel();
    }

    @Override
    public void setModel(CarType model) {
        super.setModel(model);
    }
}
class CarFactory {

    public Car buildCar(CarType model){
        if(model == null){
            return null;
        }

        if(model.toString().equalsIgnoreCase("LUXURY")){
            return new LuxuryCar(CarType.LUXURY);
        }
        else if(model.toString().equalsIgnoreCase("SEDAN")){
            return new SedanCar(CarType.SEDAN);
        }
        else{
            return new SmallCar(CarType.SMALL);
        }

    }
}






public class DriverClass {
    public static void main(String[] args){
        CarFactory cf = new CarFactory();

        Car car1= cf.buildCar(CarType.LUXURY);
        car1.construct();
        System.out.println(car1.getModel());


        Car car2= cf.buildCar(CarType.SMALL);
        car2.construct();
        System.out.println(car2.getModel());


        Car car3= cf.buildCar(CarType.SEDAN);
        car3.construct();
        System.out.println(car3.getModel());
    }
}
