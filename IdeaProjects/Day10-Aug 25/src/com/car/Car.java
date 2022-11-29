package com.car;

public abstract class Car {
    private CarType model;//enum,
    public Car(CarType model){        //constuctor
        this.model=model;
    }
   protected abstract void construct();
    public CarType getModel() { //getter method
        return model;
    }

    public void setModel(CarType model) { //setter method
        this.model = model;
    }


}
