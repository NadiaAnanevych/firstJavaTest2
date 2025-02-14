import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OtherUnitTests {
    @Test
    void sumNumbersTest() {
        int a = 3;
        int b = 2;

        //assertEquals(5, a + b);
        int actualSum = a + b;
        int expectedSum = 5;

        assertEquals(expectedSum, actualSum);
    }

    @Test
    void assertTrueFalseTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertTrue(expectedSum == actualSum);
        assertFalse(expectedSum != actualSum);

    }
}
