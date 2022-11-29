package factorydesign;
interface Shape{
    void draw();
}
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle draw() method");
    }
}
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle draw() method");
    }
}
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square draw() method");
    }
}
class ShapeFactory {
    Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        }
        if (shapeType.equalsIgnoreCase("Circle")) {
            return new Circle();
        }
        if (shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        }
        return null;
    }
}
public class FactoryPattern {
    public static void main(String[] args){
        ShapeFactory sf = new ShapeFactory();
        Shape shape1=sf.getShape("Rectangle");
        shape1.draw();
        Shape shape2=sf.getShape("Circle");
        shape2.draw();
        Shape shape3=sf.getShape("Square");
        shape3.draw();
    }
}
