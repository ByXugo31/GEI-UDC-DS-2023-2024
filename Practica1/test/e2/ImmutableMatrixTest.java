package e2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImmutableMatrixTest {
    public static ImmutableMatrix im = new ImmutableMatrix(3,4);

    @Test
    void testConstructorArray() {
        int[][] result = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        ImmutableMatrix im = new ImmutableMatrix(result);
        assertArrayEquals(result, im.toArray2D());
    }

    @Test
    void testConstructorRowCols() {
        int[][] result = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        ImmutableMatrix im = new ImmutableMatrix(2,5);
        assertArrayEquals(result, im.toArray2D());
    }

    @Test
    void testConstructorException() {
        int[][] ragged = {{1, 2, 3}, {4, 5}, {7}, {10, 11, 12}};
        assertThrows(IllegalArgumentException.class, () -> new ImmutableMatrix(ragged));
    }

    @Test
    void testToString() {
        ImmutableMatrix im = new ImmutableMatrix(3,4);
        assertEquals("[1, 2, 3, 4]\n[5, 6, 7, 8]\n[9, 10, 11, 12]\n", im.toString());
    }

    @Test
    void at() {
        assertEquals(7, im.at(1,2));
    }

    @Test
    void atException() {
        assertThrows(IllegalArgumentException.class, () -> im.at(3, 5));
    }

    @Test
    void rowCount() {
        assertEquals(3, im.rowCount());
    }

    @Test
    void columnCount() {
        assertEquals(4, im.columnCount());
    }

    @Test
    void toArray2D() {
        int[][] result = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        assertArrayEquals(result, im.toArray2D());
    }

    @Test
    void reverse() {
        int[][] result = {{4, 3, 2, 1}, {8, 7, 6, 5}, {12, 11, 10, 9}};
        assertArrayEquals(result, im.reverse().toArray2D());
    }

    @Test
    void transpose() {
        int[][] result = {{1, 5, 9}, {2, 6, 10}, {3, 7, 11}, {4, 8, 12}};
        assertArrayEquals(result, im.transpose().toArray2D());
    }

    @Test
    void reshape() {
        int[][] result = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}};
        assertArrayEquals(result, im.reshape(6).toArray2D());
    }

    @Test
    void reshapeException() {
        // 3*4 = 12 / 5 = 2.4 => error
        assertThrows(IllegalArgumentException.class, () -> im.reshape(5));
    }
}