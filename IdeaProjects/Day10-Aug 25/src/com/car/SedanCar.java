package com.car;

public class SedanCar extends Car {
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
