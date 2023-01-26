package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static domain.data.CellState.*;

/**
 * Тест на {@link PercolationImpl}.
 */
public class PercolationImplTest {
    Percolation percolation;

    @BeforeEach
    public void setUp() {
        percolation = new PercolationImpl(5);
    }

    @Test
    public void getSize() {
        percolation.closeAllCell();
        Assertions.assertEquals(5, percolation.getSize());
    }

    @Test
    public void hasPercolationV1() {
        percolation.closeAllCell();
        Assertions.assertFalse(percolation.hasPercolation());
        percolation.openCell(0, 4);
        Assertions.assertFalse(percolation.hasPercolation());
        percolation.openCell(0, 0);
        percolation.openCell(0, 1);
        percolation.openCell(0, 2);
        Assertions.assertFalse(percolation.hasPercolation());
        percolation.openCell(0, 3);
        Assertions.assertTrue(percolation.hasPercolation());
    }

    @Test
    public void hasPercolationV2() {
        percolation.closeAllCell();
        Assertions.assertFalse(percolation.hasPercolation());
        percolation.openCell(0, 0);
        percolation.openCell(1, 0);
        percolation.openCell(2, 0);
        percolation.openCell(3, 0);
        percolation.openCell(4, 0);
        Assertions.assertFalse(percolation.hasPercolation());
        percolation.openCell(0, 1);
        percolation.openCell(0, 2);
        percolation.openCell(0, 3);
        Assertions.assertFalse(percolation.hasPercolation());
        percolation.openCell(0, 4);
        Assertions.assertTrue(percolation.hasPercolation());
    }

    @Test
    public void hasPercolationV3() {
        percolation.closeAllCell();
        Assertions.assertFalse(percolation.hasPercolation());
        percolation.openCell(0, 0);
        percolation.openCell(1, 1);
        percolation.openCell(2, 2);
        percolation.openCell(3, 3);
        percolation.openCell(4, 4);
        Assertions.assertFalse(percolation.hasPercolation());
        percolation.openCell(1, 0);
        percolation.openCell(2, 1);
        percolation.openCell(3, 2);
        Assertions.assertFalse(percolation.hasPercolation());
        percolation.openCell(4, 3);
        Assertions.assertTrue(percolation.hasPercolation());
    }

    @Test
    public void hasNotPercolationV1() {
        Assertions.assertFalse(percolation.hasPercolation());
    }

    @Test
    public void hasNotPercolationV2() {
        percolation.openCell(0, 0);
        percolation.openCell(0, 1);
        percolation.openCell(0, 2);
        percolation.openCell(0, 3);
        Assertions.assertFalse(percolation.hasPercolation());
    }

    @Test
    public void hasNotPercolationV3() {
        percolation.openCell(0, 0);
        percolation.openCell(1, 0);
        percolation.openCell(2, 0);
        percolation.openCell(3, 0);
        Assertions.assertFalse(percolation.hasPercolation());
    }

    @Test
    public void hasNotPercolationV4() {
        percolation.openCell(0, 1);
        percolation.openCell(0, 2);
        percolation.openCell(0, 3);
        percolation.openCell(0, 4);
        Assertions.assertFalse(percolation.hasPercolation());
    }

    @Test
    public void hasNotPercolationV5() {
        percolation.openCell(0, 0);
        percolation.openCell(0, 1);
        percolation.openCell(0, 2);
        percolation.openCell(1, 2);
        percolation.openCell(2, 2);
        percolation.openCell(3, 2);
        percolation.openCell(3, 3);
        percolation.openCell(4, 3);
        percolation.openCell(4, 2);
        percolation.openCell(4, 1);
        percolation.openCell(4, 0);
        percolation.openCell(3, 0);
        percolation.openCell(2, 0);
        percolation.openCell(1, 0);
        percolation.openCell(0, 0);
        Assertions.assertFalse(percolation.hasPercolation());
    }

    @Test
    public void getCellStateV1() {
        Assertions.assertEquals(LOCK, percolation.getCellState(0, 0));
        percolation.openCell(0, 0);
        Assertions.assertEquals(FULL, percolation.getCellState(0, 0));
        percolation.openCell(0, 4);
        Assertions.assertEquals(OPEN, percolation.getCellState(0, 4));
        percolation.openCell(0, 1);
        percolation.openCell(0, 2);
        percolation.openCell(0, 3);
        Assertions.assertEquals(FULL, percolation.getCellState(0, 1));
        Assertions.assertEquals(FULL, percolation.getCellState(0, 2));
        Assertions.assertEquals(FULL, percolation.getCellState(0, 3));
        Assertions.assertEquals(FULL, percolation.getCellState(0, 4));
    }

    @Test
    public void getCellStateV3() {
        percolation.openCell(0, 0);
        percolation.openCell(0, 1);
        percolation.openCell(0, 2);
        percolation.openCell(0, 3);
        percolation.openCell(1, 3);
        percolation.openCell(2, 3);
        percolation.openCell(2, 2);
        Assertions.assertEquals(FULL, percolation.getCellState(2, 2));
    }
}
