package test.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class New {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    void display(){
        System.out.println("My name is " + name);
    }

    public static void main(String[] args)  {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        New h = (New)context.getBean("myHelloo");
        h.display();
    }
}
