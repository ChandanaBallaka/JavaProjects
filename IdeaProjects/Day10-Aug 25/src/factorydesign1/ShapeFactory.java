package factorydesign1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Shape{
    int length;
    int width;
    void area(int length, int width){
       // System.out.println(this.length * this.width);
    }
}
class Rectangle extends Shape{
    void area(int length,int width){
        System.out.println("Area of Recatanglr is: " +length * width);
    }
}
class Triangle extends Shape{
    void area(int length,int width){
        System.out.println("Area of Triangle is: " + 0.5 * length * width);
    }
}
class GetShapeFactory{
    Shape getShape(String shapeType){
        if(shapeType==null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        if(shapeType.equalsIgnoreCase("Triangle")){
            return new Triangle();
        }
           return null;
    }
}
public class ShapeFactory {
    public static void main(String[] args) throws IOException {
        GetShapeFactory gsf = new GetShapeFactory();
        System.out.print("Enter the shape type ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String shapeName=br.readLine();
        System.out.print("Enter the length: ");
        int length=Integer.parseInt(br.readLine());
        System.out.print("Enter the length: ");
        int width=Integer.parseInt(br.readLine());
        Shape s=gsf.getShape(shapeName);
        System.out.print("Area of "+shapeName);
        s.area(length,width);

    }
}
