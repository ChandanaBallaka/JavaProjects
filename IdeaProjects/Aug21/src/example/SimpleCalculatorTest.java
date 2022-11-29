package example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest extends SimpleCalculator {
    SimpleCalculator calculator = new SimpleCalculator();
    @org.junit.jupiter.api.BeforeAll
    static void setUp() {
        System.out.println("initial stage");
    }

    @org.junit.jupiter.api.AfterAll
    static void tearDown() {
        System.out.println("After");
    }
    @BeforeEach
    public void BeforeEachCalculation(){
        System.out.println("Before each function check");
    }
    @AfterEach
    public void AfterEachCalculation(){
        System.out.println("After Each function check");
    }
    @Test
    public void plus(){

      //int output= calculator.add(2,2);
       //assertEquals(4,output);
        assertEquals(4,calculator.add(2,2));
       // assertNotEquals(3,calculator.add(2,2));
    }
    @Test
    public void plus1(){

        //int output= calculator.add(2,2);
        //assertEquals(4,output);
       // assertEquals(4,calculator.add(2,2));
        assertNotEquals(3,calculator.add(2,2));
    }
    @Test
    public void plus2(){

        assertTrue(calculator.add(2,2)==4);
    }
}