package testing;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GradeTest extends Grade{
    Grade grade= new Grade();
@BeforeAll
static void setUp(){
    System.out.println("initial");
}
@AfterAll
static void teardown(){
    System.out.println("final");
}
    @BeforeEach
    public void BeforeEachTest() {
        System.out.println("before each function check");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each function check");
    }

    @Test
    public void testGrade() {
          int output=grade.determineGrade();
    }
}
