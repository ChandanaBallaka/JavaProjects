package evaluation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest extends Main {
      Main order = new Main();
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("Initial");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("final");
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
    void test(){
      //assertEquals(900,order.calcTax(88,9));
   }

}


