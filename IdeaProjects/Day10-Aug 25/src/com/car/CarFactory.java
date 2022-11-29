package com.car;

public class CarFactory {
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
        else if(model.toString().equalsIgnoreCase("SMALL")){
            return new SmallCar(CarType.SMALL);
        }
        return null;

    }
}
