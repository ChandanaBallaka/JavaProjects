package com.car;

public class LuxuryCar extends Car{
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
