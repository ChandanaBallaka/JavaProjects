package factorydesign5;
public abstract class Car {

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
public class Driver {
}
