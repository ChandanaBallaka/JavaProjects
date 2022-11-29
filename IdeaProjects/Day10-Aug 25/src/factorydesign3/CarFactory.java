package factorydesign3;
import java.io.IOException;

public enum CarType {
    SMALL,
    SEDAN,
    LUXURY
}
class Car {
    private String CarType;

    public void setModel() {
    }

    public enum CarType{LUXURYCAR,SMALLCAR,SEDANCAR}
    protected Car() {
    }
    void getModel(){
    }
    String setModel(String CarType){

       this.CarType=CarType;
        return CarType;
    }
}
     class LuxuryCar extends Car{
         void getModel() {

         }
         void setModel() {

         }
    }
    class SmallCar extends Car{
         void getModel() {

         }
         void setModel() {

         }
     }
      class SedanCar extends Car{
          void getModel() {

          }
          void setModel() {

          }

     }

class GetCarFactory{
    Car getCar(String CarType){
        if(CarType==null){
            return null;
        }
        if(CarType.equalsIgnoreCase("LUXURYCAR")){
            return new LuxuryCar();
        }
        if(CarType.equalsIgnoreCase("SMALLCAR")){
            return new SmallCar();
        }
        if(CarType.equalsIgnoreCase("SEDANCAR")){
            return new SedanCar();
        }
        return null;
    }
}
public class CarFactory {
    public static void main(String[] args) throws IOException {
        GetCarFactory gcf = new GetCarFactory();
        Car c1=gcf.getCar("LUXURYCAR");
        c1.getModel();
        c1.setModel();
       Car c2=gcf.getCar("SMALLCAR");
        c2.getModel();
        c2.setModel();
        Car c3=gcf.getCar("SEDANCAR");
        c3.getModel();
        c3.setModel();
    }
}
