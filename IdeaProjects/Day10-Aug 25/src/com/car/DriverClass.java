package com.car;

public class DriverClass {
    public static void main(String[] args) {

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
