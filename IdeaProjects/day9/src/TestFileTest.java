import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestFileTest extends TestFile {
    TestFile test = new TestFile();

    @org.junit.jupiter.api.BeforeAll
    static void setUp() {
        System.out.println("initial");
    }

    @org.junit.jupiter.api.AfterAll
    static void tearDown() {
        System.out.println("final");
    }
    @BeforeEach
    public void BeforeEachtest(){
        System.out.println("before each function check");
    }

    @AfterEach
    public void AfterEachtest(){
        System.out.println("after each function check");
    }

@Test
public void testSqare() {
    int output = test.Square(4);
    assertEquals(16,output);
}

@Test
public void testCount() {
    int output = test.countA("chandana");
    assertEquals(3, output);

}
}