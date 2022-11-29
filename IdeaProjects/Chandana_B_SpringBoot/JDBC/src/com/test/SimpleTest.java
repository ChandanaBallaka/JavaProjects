package com.test;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
public class SimpleTest {
    public static void main(String[] args) {

        ApplicationContext factory =new ClassPathXmlApplicationContext("applicationContext.xml");

        EmpDao dao=(EmpDao)factory.getBean("edao");
        int status=dao.update1(new Employee(23,"Chandana",35000));
        System.out.println(status);
        int status2=dao.update1(new Employee(44,"Yashwith",35000));
        System.out.println(status2);
    }

}
